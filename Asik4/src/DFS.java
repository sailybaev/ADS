public class DFS<V> extends Search<V>{
    public DFS(MyGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, V source) {
        marked.add(source);

        for (V v : graph.getAdjacentVertices(source)) {
            if (marked.contains(v) == false) {
                edgeTo.put(v, source);
                dfs(graph, v);
            }
        }
    }
}
