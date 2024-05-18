import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);

        for (V v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);

        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<V> graph) {

        while (true) {
            V vertex = null;
            double minDist = Double.POSITIVE_INFINITY;

            for (V v : distances.keySet()) {
                if (marked.contains(v) == false && distances.get(v) < minDist) {
                    vertex = v;
                    minDist = distances.get(v);
                }
            }

            if (vertex == null) {
                break;
            }

            marked.add(vertex);

            for (V v : graph.getAdjacentVertices(vertex)) {
                if (marked.contains(v) == false) {
                    double newDist = distances.get(vertex) + graph.getWeight(vertex, v);
                    if (newDist < distances.get(v)) {
                        distances.put(v, newDist);
                        edgeTo.put(v, vertex);
                    }
                }
            }
        }
    }
}
