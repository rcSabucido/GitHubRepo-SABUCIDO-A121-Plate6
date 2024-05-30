import java.util.*;

public class Graph {
    private HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();
    private Set<String> vertices;

    public Graph(String[] edgeList) {
        adjacencyList = new HashMap<>();
        vertices = new HashSet<>();
        buildGraph(edgeList);
    }

    private void buildGraph(String[] edgeList) {
        for (String edge : edgeList) {
            String[] vertexPair = edge.split("-");
            String u = vertexPair[0];
            String v = vertexPair[1];
        }
    }
}
