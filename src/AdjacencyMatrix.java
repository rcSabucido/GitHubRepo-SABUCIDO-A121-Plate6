/*
SABUCIDO, Ryz Clyd R.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/
import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        HashMap<String, Integer> edgeList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeList.put(edge, matrix[i][j]);
                }
            }
        }

        System.out.println("Edge list and their values:");
        for (Map.Entry<String, Integer> entry : edgeList.entrySet()) {
            String edge = entry.getKey();
            int value = entry.getValue();

            System.out.println(edge + " = " + value);
        }

    }
}
