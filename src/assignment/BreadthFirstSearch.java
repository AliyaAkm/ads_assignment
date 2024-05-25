package assignment_4;
import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, Boolean> marked;
    private Map<V, V> edgeTo;
    private V start;

    public BreadthFirstSearch(MyGraph<V> graph, V start) {
        this.start = start;
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        bfs(graph, start);
    }

    private void bfs(MyGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        marked.put(start, true);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (V neighbor : graph.getAdjacentVertices(v)) {
                if (!marked.containsKey(neighbor)) {
                    queue.add(neighbor);
                    marked.put(neighbor, true);
                    edgeTo.put(neighbor, v);
                }
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
