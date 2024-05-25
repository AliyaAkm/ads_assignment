package assignment_4;
import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<V, Double> distTo;
    private Map<V, V> edgeTo;
    private PriorityQueue<VertexDist<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDist::getDist));

        for (V vertex : graph.getVertices().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        pq.add(new VertexDist<>(graph.getVertex(start), 0.0));

        while (!pq.isEmpty()) {
            VertexDist<V> vd = pq.poll();
            Vertex<V> v = vd.getVertex();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(entry.getKey(), v, entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> w, Vertex<V> v, double weight) {
        double newDist = distTo.get(v.getData()) + weight;
        if (newDist < distTo.get(w.getData())) {
            distTo.put(w.getData(), newDist);
            edgeTo.put(w.getData(), v.getData());
            pq.add(new VertexDist<>(w, newDist));
        }
    }

    @Override
    public boolean hasPathTo(V vertex) {
        return distTo.containsKey(vertex) && distTo.get(vertex) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<V> pathTo(V vertex) {
        if (!hasPathTo(vertex)) return null;
        List<V> path = new LinkedList<>();
        for (V x = vertex; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }
}

class VertexDist<V> {
    private Vertex<V> vertex;
    private double dist;

    public VertexDist(Vertex<V> vertex, double dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public double getDist() {
        return dist;
    }
}
