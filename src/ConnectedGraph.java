import java.util.Arrays;
import java.util.Scanner;

public class ConnectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        String[] edgeList = new String[n];

        for (int i = 0; i < edgeList.length; i++) {
            System.out.println("Enter edge " + i + ": ");
            edgeList[i] = sc.next();
            sc.nextLine();
        }

        System.out.println(Arrays.toString(edgeList));
    }
}
