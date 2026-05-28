public class Graph {
    private final int vertexCount;
    private final int[][] matrix;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.matrix = new int[vertexCount][vertexCount];
    }

    public void addEdge(int u, int v, int weight) {
        matrix[u][v] = weight;
        matrix[v][u] = weight;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int[][] getAdjacencyMatrix() {
        return matrix;
    }
}