// 2. Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
// the number of times each edge appears.

import java.util.*;

public class GraphEdgeCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the adjacency matrix
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];

        // Input the adjacency matrix
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for an edge):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // List edges and count occurrences
        System.out.println("Edges of the graph and their occurrences:");
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.println("(" + i + ", " + j + "): " + countEdgeOccurrences(adjacencyMatrix, i, j));
                }
            }
        }
    }

    // Method to count occurrences of an edge in the adjacency matrix
    private static int countEdgeOccurrences(int[][] adjacencyMatrix, int vertex1, int vertex2) {
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex1][i] == 1 && adjacencyMatrix[vertex2][i] == 1) {
                count++;
            }
        }
        return count;
    }
}
