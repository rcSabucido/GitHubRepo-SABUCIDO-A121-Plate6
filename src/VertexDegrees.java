import java.util.Scanner;

public class VertexDegrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the vertex pairs of the graph (format: U-V, W-X, ...): ");
        String[] edgeList = sc.nextLine().split(", ");
        Graph graph = new Graph(edgeList);

        System.out.print("Enter a vertex: ");
        String vertex = sc.nextLine();
        int vertexDegree = graph.getNumberOfDegrees(vertex);

        System.out.println("Vertex " + vertex + " has " + vertexDegree + " degrees");
    }
}
