import java.util.Scanner;

public class BipartiteGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the vertex pairs of the graph (format: U-V, W-X, ...): ");
        String[] edgeList = sc.nextLine().split(", ");
        Graph graph = new Graph(edgeList);

        if (graph.isBipartite()) {
            System.out.println("The graph is a bipartite graph");
        } else {
            System.out.println("The graph is not a bipartite graph");
        }
    }
}
