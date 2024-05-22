// 7. Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
// each edge appears. The program should construct an incidence matrix for the graph.

import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices and edges
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        // Initialize the incidence matrix
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        // Input the edges (vertex pairs) associated with the edges and the number of times each edge appears
        System.out.println("Enter the edges (vertex pairs) and the number of times each edge appears:");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int edgeCount = scanner.nextInt();

            // For undirected graphs, increment the corresponding cells by the edge count
            incidenceMatrix[u][i] += edgeCount;
            incidenceMatrix[v][i] += edgeCount; // For undirected graphs
        }

        scanner.close();

        // Output the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
