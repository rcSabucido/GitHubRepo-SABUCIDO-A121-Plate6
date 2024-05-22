import java.util.Arrays;
import java.util.Scanner;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the edge pairs of the graph (separate by comma): ");
        String[] edgeList = sc.nextLine().split(", ");

        System.out.println(Arrays.toString(edgeList));
    }
}
