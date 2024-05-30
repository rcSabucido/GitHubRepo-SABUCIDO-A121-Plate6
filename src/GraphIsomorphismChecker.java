/*
SABUCIDO, Ryz Clyd R.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/
import java.util.*;

public class GraphIsomorphismChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graphs: ");
        int numberOfVertices = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> vertexIndexMap1 = new HashMap<>();
        Map<String, Integer> vertexIndexMap2 = new HashMap<>();

        int[][] adjacencyMatrix1 = new int[numberOfVertices][numberOfVertices];
        int[][] adjacencyMatrix2 = new int[numberOfVertices][numberOfVertices];

        System.out.println("Enter edges for Graph 1 (e.g., \"AB\"). (Type 'end' to finish):");
        inputEdges(scanner, adjacencyMatrix1, vertexIndexMap1);

        System.out.println("Enter edges for Graph 2 (e.g., \"AB\"). (Type 'end' to finish):");
        inputEdges(scanner, adjacencyMatrix2, vertexIndexMap2);

        if (vertexIndexMap1.size() != numberOfVertices || vertexIndexMap2.size() != numberOfVertices) {
            System.out.println("The number of vertices used in edges does not match the specified number of vertices.");
            return;
        }

        if (areIsomorphic(adjacencyMatrix1, adjacencyMatrix2, numberOfVertices)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }

    private static void inputEdges(Scanner scanner, int[][] adjacencyMatrix, Map<String, Integer> vertexIndexMap) {
        int index = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            if (input.length() != 2) {
                System.out.println("Invalid input. Please enter edges in the format \"AB\".");
                continue;
            }

            String u = input.substring(0, 1);
            String v = input.substring(1);

            if (!vertexIndexMap.containsKey(u)) {
                vertexIndexMap.put(u, index++);
            }
            if (!vertexIndexMap.containsKey(v)) {
                vertexIndexMap.put(v, index++);
            }

            int uIndex = vertexIndexMap.get(u);
            int vIndex = vertexIndexMap.get(v);

            adjacencyMatrix[uIndex][vIndex]++;
            adjacencyMatrix[vIndex][uIndex]++;
        }
    }

    private static boolean areIsomorphic(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2, int numberOfVertices) {
        int[] permutation = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            permutation[i] = i;
        }

        do {
            if (checkPermutation(adjacencyMatrix1, adjacencyMatrix2, permutation, numberOfVertices)) {
                return true;
            }
        } while (nextPermutation(permutation));

        return false;
    }

    private static boolean checkPermutation(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2, int[] permutation, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyMatrix1[i][j] != adjacencyMatrix2[permutation[i]][permutation[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean nextPermutation(int[] permutation) {
        int length = permutation.length;
        int i = length - 2;
        while (i >= 0 && permutation[i] >= permutation[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = length - 1;
        while (permutation[j] <= permutation[i]) {
            j--;
        }
        swap(permutation, i, j);
        reverse(permutation, i + 1, length - 1);
        return true;
    }

    private static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }

    private static void reverse(int[] permutation, int start, int end) {
        while (start < end) {
            swap(permutation, start, end);
            start++;
            end--;
        }
    }
}

