import java.util.Scanner;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int connectCount = 0;

        System.out.print("Enter the edge pairs of the graph (separate by comma): ");
        String[] edgeList = sc.nextLine().split(", ");

        for (int i = 0; i < edgeList.length; i++) {
            for (int j = i + 1; j < edgeList.length; j++) {
                if (edgeList[i].charAt(edgeList[i].length() - 1) != edgeList[j].charAt(0)) {
                    System.out.println("Graph is not connected");
                } else {
                    connectCount++;
                }
            }
        }

        System.out.println("Number of connected graphs: " + connectCount);
    }
}
