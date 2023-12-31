import java.util.Arrays;

public class Program_3 {
    static int V = 9;       // Number of vertices in the graph

    // To calculate min. distance
    static int minDistance(int dist[], boolean shortestPathTreeSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!shortestPathTreeSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // For printing the output
    static void printSolution(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    // Main Dijkstra Algo
    static void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        boolean shortestPathTreeSet[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, shortestPathTreeSet);
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!shortestPathTreeSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        System.out.println("Shortest Path using \"Dijkstra's Algorithm\" \n");
        dijkstra(graph, 0);
    }
}
