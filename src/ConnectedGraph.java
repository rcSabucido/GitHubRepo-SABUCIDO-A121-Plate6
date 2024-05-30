import java.util.*;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge pairs of the graph (format: U-V, W-X...): ");
        String[] edgeList = sc.nextLine().split(", ");

        HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();
        Set<String> vertices = new HashSet<>();

        for (String edge : edgeList) {
            String[] vertexPair = edge.split("-");
            String u = vertexPair[0];
            String v = vertexPair[1];
            vertices.add(u);
            vertices.add(v);
            adjacencyList.putIfAbsent(u, new ArrayList<>());
            adjacencyList.putIfAbsent(v, new ArrayList<>());
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }


        Set<String> visited = new HashSet<>();
        List<Set<String>> connectedComponents = new ArrayList<>();

        for (String vertex : vertices) {
            if (!visited.contains(vertex)) {
                Set<String> component = new HashSet<>();
                dfs(vertex, adjacencyList, visited, component);
                connectedComponents.add(component);
            }
        }

        int componentsSize = connectedComponents.size();
        if (componentsSize == 1) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
            System.out.println("Number of connected components: " + componentsSize);
            System.out.println("Disconnected Vertices: ");
            for (Set<String> component : connectedComponents) {
                System.out.println(component);
            }
        }

    }

    private static void dfs(String vertex, HashMap<String, ArrayList<String>> graph, Set<String> visited, Set<String> component) {
        visited.add(vertex);
        component.add(vertex);
        for (String neighbor: graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}