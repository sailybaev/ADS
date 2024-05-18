import java.util.LinkedList;
import java.util.Queue;

public class BFS <V> extends Search<V>{
    public BFS(MyGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (queue.isEmpty() == false) {
            V v = queue.poll();

            for (Vertex<V> vertex : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (marked.contains(vertex.getData()) == false) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), v);
                    queue.add(vertex.getData());
                }
            }
        }
    }
}
