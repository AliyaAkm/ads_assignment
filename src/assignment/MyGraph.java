package assignment_4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyGraph<V> {
    private Map<V, Set<V>> vertices;
    private boolean directed;

    public MyGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addEdge(V source, V dest) {
        vertices.computeIfAbsent(source, k -> new HashSet<>()).add(dest);
        if (!directed) {
            vertices.computeIfAbsent(dest, k -> new HashSet<>()).add(source);
        }
    }

    public Set<V> getAdjacentVertices(V vertex) {
        return vertices.getOrDefault(vertex, new HashSet<>());
    }

    public Set<V> getVertices() {
        return vertices.keySet();
    }
}
