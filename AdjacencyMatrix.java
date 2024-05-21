// 6.  Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
// adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)

import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        // Input the number of edges
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        // Input the edges (vertex pairs)
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            // If multiple edges or directed edges are present, increment the corresponding cell by 1
            adjacencyMatrix[u][v]++;
            adjacencyMatrix[v][u]++; // For undirected graphs
        }

        scanner.close();

        // Output the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
