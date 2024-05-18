class MyGraph<V> extends WeightedGraph<V> {
    public MyGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V src, V dest) {
        super.addEdge(src, dest, 1.0);
    }

}