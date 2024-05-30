import java.util.*;

public class CycleGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge pairs of the graph (format: U-V, W-X...): ");
        String[] edgeList = sc.nextLine().split(", ");

        Graph graph = new Graph(edgeList);

        if (graph.isCycle()) {
            System.out.println("Graph is a cycle");
        } else {
            System.out.println("Graph is not a cycle");
        }
    }
}
