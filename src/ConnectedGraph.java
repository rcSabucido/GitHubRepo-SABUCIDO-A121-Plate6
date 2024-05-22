import java.util.Scanner;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int connectCount = 0;

        System.out.print("Enter the edge pairs of the graph (separate by comma): ");
        String[] edgeList = sc.nextLine().split(", ");
        String hold = "";
        for (int i = 0; i < edgeList.length; i++) {
            for (int j = i + 1; j < edgeList.length; j++) {
                System.out.println(edgeList[i] + "->" + edgeList[j]);
                if (edgeList[i].charAt(edgeList[i].length() - 1) == edgeList[j].charAt(0)) {
                    hold = "Graph is connected";
                    connectCount++;
                } else if (edgeList[i].charAt(0) == edgeList[j].charAt(edgeList[j].length() - 1)) {
                    hold = "Graph is connected";
                    connectCount++;
                } else if (edgeList[i].charAt(0) == edgeList[j].charAt(0)) {
                    hold = "Graph is connected";
                }
                else {
                    hold = "Graph is not connected";
                }
                System.out.println(hold);
            }

        }
        System.out.println(hold);
        System.out.println("Number of connected graphs: " + connectCount);
    }
}
