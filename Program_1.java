import java.util.Scanner;

public class Program_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int size = scanner.nextInt();

        char[] nodes = new char[size];

        System.out.print("Enter vertices: ");
        for (int i = 0; i < size; i++) {
            nodes[i] = scanner.next().charAt(0);
        }
        for (int i = 0; i < size; i++) {
            System.out.print("Enter size of neighbouring vertex \"" + nodes[i] + "\": ");
            int neighbourVertexSize = scanner.nextInt();
            char[] neighbourVertices = new char[neighbourVertexSize];

            System.out.print("Enter neighbouring vertices of: \"" + nodes[i] + "\": ");
            for (int j = 0; j < neighbourVertexSize; j++) {
                neighbourVertices[j] = scanner.next().charAt(0);
            }

            System.out.print("Node: " + nodes[i]);
            for (int j = 0; j < neighbourVertices.length; j++) {
                System.out.print(" -> Linked List: " + neighbourVertices[j]);
            }
            System.out.println();

            System.out.println("Node: " + nodes[i] + " Adjacent Matrix ");
            for (int j = 0; j < neighbourVertices.length; j++) {
                System.out.println(neighbourVertices[j] + ": T ");
            }
        }
        scanner.close();
    }
}