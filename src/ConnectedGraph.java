import java.util.*;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge pairs of the graph (format: U-V, W-X...): ");
        String[] edgeList = sc.nextLine().split(", ");

        Graph graph = new Graph(edgeList);

        if (graph.isConnected()) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
            System.out.println("Number of connected components: " + graph.getNumberOfConnectedComponents());
            System.out.println("Disconnected components: ");
            for (Set<String> component: graph.getConnectedComponents()) {
                System.out.println(component);
            }
        }

    }
}