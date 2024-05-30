import java.util.*;

public class GraphAdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the graph Directed? (y/n): ");
        boolean isDirected = scanner.nextLine().trim().equalsIgnoreCase("y");

        HashMap<String, Integer> vertexIndexMap = new HashMap<>();
        HashSet<String> vertexSet = new HashSet<>();
        ArrayList<String[]> edgeList = new ArrayList<>();


        System.out.println("Enter the edges (e.g. \"AB\") (type 'end' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end"))
                break;

            if (input.length() != 2){
                System.out.println("Invalid edge format. Please use \"AB\" format.");
                continue;
            }

            String startVertex = input.substring(0,1);
            String endVertex = input.substring(1);

            edgeList.add(new String[]{startVertex, endVertex});

            if (!vertexIndexMap.containsKey(startVertex)){
                vertexIndexMap.put(startVertex, vertexSet.size());
                vertexSet.add(startVertex);
            }
            if (!vertexIndexMap.containsKey(endVertex)){
                vertexIndexMap.put(endVertex, vertexSet.size());
                vertexSet.add(endVertex);
            }

        }

        int numVertices = vertexSet.size();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];
        for (String[] edge : edgeList) {
            int startIndex = vertexIndexMap.get(edge[0]);
            int endIndex = vertexIndexMap.get(edge[1]);
            adjacencyMatrix[startIndex][endIndex]++;
            if(!isDirected && startIndex != endIndex){
                adjacencyMatrix[endIndex][startIndex]++;
            }
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("[ ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println("]");
        }

        scanner.close();
    }
}
