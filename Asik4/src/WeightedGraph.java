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
        if (hasVertex(source) == false) {
            addVertex(source);
        }

        if (hasVertex(dest) == false) {
            addVertex(dest);
        }

        getVertex(source).addAdjacentVertex(getVertex(dest), weight);

        if (directed == false) {
            getVertex(dest).addAdjacentVertex(getVertex(source), weight);
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

        return getVertex(source).getAdjacentVertices().containsKey(getVertex(dest));
    }

    public Double getWeight(V source, V dest) {
        if(hasEdge(source, dest) == false) {
            return Double.POSITIVE_INFINITY;
        }

        return mp.get(source).getAdjacentVertices().get(getVertex(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return mp.keySet();
    }







}
