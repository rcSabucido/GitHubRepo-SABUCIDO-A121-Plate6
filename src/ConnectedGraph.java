import java.util.*;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge pairs of the graph (format: U-V, W-X...): ");
        String[] edgeList = sc.nextLine().split(", ");

        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        Set<String> vertices = new HashSet<>();

        for (String edge : edgeList) {
            String[] vertex = edge.split("-");
            String u = vertex[0];
            String v = vertex[1];
            vertices.add(u);
            vertices.add(v);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        Set<String> visited = new HashSet<>();
        List<Set<String>> connectedComponents = new ArrayList<>();

        for (String vertex : vertices) {
            if (!visited.contains(vertex)) {
                Set<String> component = new HashSet<>();
                dfs(vertex, graph, visited, component);
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
        Stack<String> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                component.add(current);
                for (String neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}