import java.util.Scanner;

public class Program_5 {
    private int vertices;
    private int[][] adjacencyMatrix;

    Program_5(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    void topologicalSort() {
        int[] inDegree = new int[vertices];

        // To Calculate degrees of vertices
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                inDegree[j] += adjacencyMatrix[i][j];
            }
        }

        // Create a stack to store nodes with in-degree 0
        int[] stack = new int[vertices];
        int stackIndex = 0;

        // Initialize stack with nodes having in-degree 0
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                stack[stackIndex++] = i;
            }
        }

        // Initialize the result list
        int[] result = new int[vertices];
        int resultIndex = 0;
        while (stackIndex > 0) {
            int node = stack[--stackIndex];
            result[resultIndex++] = node;
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[node][i] == 1) {
                    if (--inDegree[i] == 0) {
                        stack[stackIndex++] = i;
                    }
                }
            }
        }

        // Print the topological order
        for (int i = 0; i < resultIndex; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Program_5 graph = new Program_5(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge " + (i + 1) + " Source and Destination (Seperated by empty space): ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        scanner.close();

        System.out.println("Topological Sort Order:");
        graph.topologicalSort();
    }
}