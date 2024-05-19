import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V>{
    private boolean directed;
    private Map<V, Vertex<V>> mp = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(V data) {
        mp.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, Double weight) {
        if (mp.containsKey(source) == false) {
            addVertex(source);
        }

        if (mp.containsKey(dest) == false) {
            addVertex(dest);
        }

        mp.get(source).addAdjacentVertex(mp.get(dest), weight);

        if (directed == false) {
            mp.get(dest).addAdjacentVertex(mp.get(source), weight);
        }

    }


    public boolean hasVertex(V data) {
        return mp.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return mp.get(data);
    }

    public Iterable<V> getVertices() {
        return mp.keySet();
    }

    public boolean hasEdge(V source, V dest) {
        if (hasVertex(source) == false) {
            return false;
        }

        return mp.get(source).getAdjacentVertices().containsKey(mp.get(dest));
    }

    public Double getWeight(V source, V dest) {
        if(hasEdge(source, dest) == false) {
            return Double.POSITIVE_INFINITY;
        }

        return mp.get(source).getAdjacentVertices().get(mp.get(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return mp.keySet();
    }







}
