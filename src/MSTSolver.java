import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MSTSolver {

    public static class MSTEdge implements Comparable<MSTEdge> {
        public final int from, to, weight;

        public MSTEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // Permitir que la PriorityQueue ordene por peso de menor a mayor
        @Override
        public int compareTo(MSTEdge other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return String.format("(%d - %d, Peso: %d)", from, to, weight);
        }
    }

    // --- CLASE INTERNA PARA UNION-FIND ---
    private static class UnionFind {
        private final int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Cada nodo empieza siendo su propia raíz
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            // Optimización por compresión de caminos
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            
            if (rootI != rootJ) {
                parent[rootI] = rootJ; // Conectar un árbol con el otro
                return true; // Unión exitosa (no había ciclo)
            }
            return false; // Ya estaban en el mismo conjunto (¡ciclo detectado!)
        }
    }

    // --- ALGORITMO DE KRUSKAL ---
    public List<MSTEdge> kruskal(Graph graph) {
        List<MSTEdge> mst = new ArrayList<>();
        int vertices = graph.getVertexCount();
        int[][] matrix = graph.getAdjacencyMatrix();

        // Cola de prioridad para ordenar automáticamente las aristas por peso
        PriorityQueue<MSTEdge> minHeap = new PriorityQueue<>();

        // 1. Recorrer la matriz usando j > i para extraer aristas únicas
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    minHeap.add(new MSTEdge(i, j, matrix[i][j]));
                }
            }
        }

        // 2. Inicializar Union-Find
        UnionFind uf = new UnionFind(vertices);

        // 3. Procesar las aristas en orden ascendente hasta vaciar la cola o completar el MST
        while (!minHeap.isEmpty() && mst.size() < vertices - 1) {
            MSTEdge edge = minHeap.poll();

            // Intenta unir los conjuntos de ambos extremos de la arista
            if (uf.union(edge.from, edge.to)) {
                mst.add(edge); // Si se pudo unir sin ciclos, va para el MST
            }
        }

        return mst;
    }

    public List<MSTEdge> prim(Graph graph){
        return prim(graph, 0);
    }

    private List<MSTEdge> prim(Graph graph, int startVertex) {
        List<MSTEdge> mst = new ArrayList<>();
        int vertices = graph.getVertexCount();
        int[][] matrix = graph.getAdjacencyMatrix();
        boolean[] visited = new boolean[vertices];
        // "->" significa "de" y "<-" significa "a" en el contexto de la arista
        PriorityQueue<MSTEdge> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        // Marcar el vértice inicial como visitado.
        visited[startVertex] = true;

        // Agregar a la cola todas las aristas que salen del vértice inicial.
        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (matrix[startVertex][neighbor] > 0) {
                queue.add(new MSTEdge(startVertex, neighbor, matrix[startVertex][neighbor]));
            }
        }

        // Tomar siempre la arista de menor peso que conecte con un vértice no visitado.
        while (!queue.isEmpty() && mst.size() < vertices - 1) {
            MSTEdge edge = queue.poll();

            // Si el destino ya fue visitado, esta arista no sirve para el MST.
            if (visited[edge.to]) {
                continue;
            }

            // Marcar el nuevo vértice, guardar la arista y expandir sus vecinos.
            visited[edge.to] = true;
            mst.add(edge);

            // Insertar en la cola las aristas que salgan del nuevo vértice.
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (matrix[edge.to][neighbor] > 0 && !visited[neighbor]) {
                    queue.add(new MSTEdge(edge.to, neighbor, matrix[edge.to][neighbor]));
                }
            }
        }

        return mst;
    }
}