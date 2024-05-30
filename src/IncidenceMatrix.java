/*
SABUCIDO, Ryz Clyd R.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/
import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Set<String> vertexSet = new HashSet<>();
        Map<String, Integer> vertexIndexMap = new HashMap<>();
        List<String[]> edgeList = new ArrayList<>();

        System.out.println("Enter the edges (e.g., \"AB\"). (Type 'end' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            if (input.length() != 2) {
                System.out.println("Invalid edge format. Please use the format \"AB\".");
                continue;
            }

            String startVertex = input.substring(0, 1);
            String endVertex = input.substring(1);

            vertexSet.add(startVertex);
            vertexSet.add(endVertex);

            edgeList.add(new String[]{startVertex, endVertex});
        }

        if (vertexSet.size() != vertices) {
            System.out.println("The number of unique vertices in the edges does not match the number of vertices provided.");
            System.exit(0);
        }

        int vertexIdx = 0;
        for (String vertex : vertexSet) {
            vertexIndexMap.put(vertex, vertexIdx++);
        }

        int[][] incidenceMatrix = new int[vertices][edgeList.size()];

        for (int i = 0; i < edgeList.size(); i++) {
            String[] edge = edgeList.get(i);
            int startIndex = vertexIndexMap.get(edge[0]);
            int endIndex = vertexIndexMap.get(edge[1]);
            incidenceMatrix[startIndex][i]++;
            if (!edge[0].equals(edge[1])) {
                incidenceMatrix[endIndex][i] += 1;
            }
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("[ ");
            for (int j = 0; j < edgeList.size(); j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println("]");
        }

        scanner.close();
    }
}
