/*
SABUCIDO, Ryz Clyd R.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/
import java.util.*;

public class Graph {
    private final HashMap<String, ArrayList<String>> adjacencyList;
    private final Set<String> vertices;
    private final ArrayList<Set<String>> connectedComponents;

    public Graph(String[] edgeList) {
        adjacencyList = new HashMap<>();
        vertices = new HashSet<>();
        connectedComponents = new ArrayList<>();
        buildGraph(edgeList);
    }

    private void buildGraph(String[] edgeList) {
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
    }

    public boolean isConnected() {
        Set<String> visited = new HashSet<>();

        for (String vertex : vertices) {
            if (!visited.contains(vertex)) {
                Set<String> component = new HashSet<>();
                dfs(vertex, visited, component);
                connectedComponents.add(component);
            }
        }
        return connectedComponents.size() == 1;
    }

    private void dfs(String vertex, Set<String> visited, Set<String> component) {
        visited.add(vertex);
        component.add(vertex);
        for (String neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, component);
            }
        }
    }

    public int getNumberOfConnectedComponents() {
        return connectedComponents.size();
    }

    public List<Set<String>> getConnectedComponents() {
        return connectedComponents;
    }

    public boolean isCycle() {
        if(!isConnected()) {
            return false;
        }

        for (String vertex : vertices) {
            if (adjacencyList.get(vertex).size() != 2) {
                return false;
            }
        }

        return true;
    }

    public int getNumberOfDegrees(String vertex) {
        return adjacencyList.get(vertex).size();
    }

    public boolean isBipartite() {
        HashMap<String, Integer> color = new HashMap<>();
        for (String vertex : vertices) {
            if (!color.containsKey(vertex)) {
                if (!dfsCheckBipartite(vertex, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfsCheckBipartite(String vertex, HashMap<String, Integer> color, int currentColor) {
        color.put(vertex, currentColor);
        int nextColor = 1 - currentColor;

        for(String neighbor : adjacencyList.get(vertex)) {
            if (!color.containsKey(neighbor)) {
                if (!dfsCheckBipartite(neighbor, color, nextColor)) {
                    return false;
                }
            } else if (color.get(neighbor) == currentColor) {
                return false;
            }
        }
        return true;
    }


}

