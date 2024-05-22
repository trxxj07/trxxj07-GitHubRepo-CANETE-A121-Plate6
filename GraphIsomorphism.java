// 8. Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.

import java.util.*;

public class GraphIsomorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.println("Enter the number of vertices for both graphs:");
        int numVertices = scanner.nextInt();

        // Input the adjacency matrix for the first graph
        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] graph1 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        // Input the adjacency matrix for the second graph
        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] graph2 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // Check if the two graphs are isomorphic
        if (areIsomorphic(graph1, graph2, numVertices)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    // Function to check if two graphs are isomorphic
    private static boolean areIsomorphic(int[][] graph1, int[][] graph2, int numVertices) {
        // Generate all permutations of vertex indices
        List<int[]> permutations = generatePermutations(numVertices);

        for (int[] perm : permutations) {
            if (checkIsomorphism(graph1, graph2, perm, numVertices)) {
                return true;
            }
        }
        return false;
    }

    // Function to generate all permutations of vertex indices
    private static List<int[]> generatePermutations(int numVertices) {
        List<int[]> permutations = new ArrayList<>();
        int[] perm = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            perm[i] = i;
        }
        permute(perm, 0, permutations);
        return permutations;
    }

    // Helper function to generate permutations recursively
    private static void permute(int[] perm, int index, List<int[]> permutations) {
        if (index == perm.length) {
            permutations.add(perm.clone());
            return;
        }
        for (int i = index; i < perm.length; i++) {
            swap(perm, index, i);
            permute(perm, index + 1, permutations);
            swap(perm, index, i);
        }
    }

    // Helper function to swap elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Function to check if two graphs are isomorphic given a permutation of vertices
    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] perm, int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (graph1[i][j] != graph2[perm[i]][perm[j]]) {
                    return false;
                }
            }
        }
        return true;
    }
}
