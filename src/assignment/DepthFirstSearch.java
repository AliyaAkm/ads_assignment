package assignment_4;
import java.util.*;

public class DepthFirstSearch<V> implements Search<V> {
    private Map<V, Boolean> marked;
    private Map<V, V> edgeTo;
    private V start;

    public DepthFirstSearch(MyGraph<V> graph, V start) {
        this.start = start;
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        dfs(graph, start);
    }

    private void dfs(MyGraph<V> graph, V v) {
        marked.put(v, true);
        for (V w : graph.getAdjacentVertices(v)) {
            if (!marked.containsKey(w)) {
                edgeTo.put(w, v);
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(V vertex) {
        return marked.containsKey(vertex);
    }

    @Override
    public List<V> pathTo(V vertex) {
        if (!hasPathTo(vertex)) return null;
        List<V> path = new LinkedList<>();
        for (V x = vertex; x != start; x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
