// 4.  Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of vertex.

import java.util.*;

public class VertexDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        // Create an array to store the degree of each vertex
        int[] degree = new int[numVertices];

        // Input the number of edges
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        // Input the edges (vertex pairs)
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < numEdges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            // Increment the degree of each vertex
            degree[v1]++;
            degree[v2]++;
        }

        scanner.close();

        // Output the degree of each vertex
        System.out.println("Vertex Degrees:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }
    }
}
