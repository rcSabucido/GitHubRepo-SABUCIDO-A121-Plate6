/*
SABUCIDO, Ryz Clyd R.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/
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
