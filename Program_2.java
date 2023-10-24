class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] stack = new int[vertices];
        int top = -1;

        stack[++top] = startVertex;

        while (top >= 0) {
            int vertex = stack[top--];

            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;

                for (int neighbor = 0; neighbor < vertices; neighbor++) {
                    if (adjacencyMatrix[vertex][neighbor] == 1 && !visited[neighbor]) {
                        stack[++top] = neighbor;
                    }
                }
            }
        }
        System.out.println();
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] queue = new int[vertices];
        int front = 0, rear = -1;

        queue[++rear] = startVertex;

        while (front <= rear) {
            int vertex = queue[front++];

            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;

                for (int neighbor = 0; neighbor < vertices; neighbor++) {
                    if (adjacencyMatrix[vertex][neighbor] == 1 && !visited[neighbor]) {
                        queue[++rear] = neighbor;
                    }
                }
            }
        }
        System.out.println();
    }
}

public class Program_2 {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Depth-First Search (DFS):");
        graph.dfs(0);

        System.out.println("Breadth-First Search (BFS):");
        graph.bfs(0);
    }
}