public class DemoMST {
public static void main(String[] args) {
    //Inicialización del grafo
    String[] labels = {"A", "B", "C", "D", "E", "F"};
    Graph graph = new Graph(labels.length);
    graph.addEdge(0, 1, 4);
    graph.addEdge(0, 2, 3);
    graph.addEdge(1, 2, 1);
    graph.addEdge(1, 3, 2);
    graph.addEdge(2, 3, 4);
    graph.addEdge(3, 4, 2);
    graph.addEdge(4, 5, 6);
    graph.addEdge(3, 5, 3);

    MSTSolver solver = new MSTSolver();
    // imprimir solver.prim(graph, 0) y solver.kruskal(graph)
    }
}