import java.util.List;

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
        List<MSTSolver.MSTEdge> kruskalResult = solver.kruskal(graph);
        mostrarMst(kruskalResult, labels);
        // imprimir solver.prim(graph, 0) y solver.kruskal(graph)
        }

    private static void mostrarMst(List<MSTSolver.MSTEdge> edges, String[] labels) {
        int pesoTotal = 0;
        
        for (MSTSolver.MSTEdge edge : edges) {
            String origen = labels[edge.from];
            String destino = labels[edge.to];
            System.out.printf("Arista conectada: %s - %s | Peso: %d\n", origen, destino, edge.weight);
            pesoTotal += edge.weight;
        }
        
        System.out.println("----------------------------------------");
        System.out.println("Cantidad total de aristas: " + edges.size());
        System.out.println("Costo o peso total del MST: " + pesoTotal);
        System.out.println("----------------------------------------");
    }
}


