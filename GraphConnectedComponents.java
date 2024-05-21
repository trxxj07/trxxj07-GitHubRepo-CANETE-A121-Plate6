// 1. Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
// and find the number of connected components if it is not connected.

import java.util.*;

public class GraphConnectedComponents {

    // Adjacency list representation of the graph
    private LinkedList<Integer>[] adjList;
    private int numVertices;

    // Constructor to initialize the graph
    public GraphConnectedComponents(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    // Method to perform DFS and mark visited nodes
    private void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adjList[v]) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    // Method to check if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[numVertices];
        DFS(0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    // Method to count the number of connected components
    public int countConnectedComponents() {
        boolean[] visited = new boolean[numVertices];
        int count = 0;
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        }
        return count;
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices
        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();

        // Input number of edges
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        // Create a graph
        GraphConnectedComponents graph = new GraphConnectedComponents(vertices);

        // Input edges
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        scanner.close();

        // Check if the graph is connected and print the result
        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int components = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + components);
        }
    }
}
