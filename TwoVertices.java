// FRQ 4: Two Vertices

//part a
import java.util.ArrayList;

public class TwoVertices {

    public static boolean isComplete(int[][] m) {
        int i = 0;
        while (i < m.length) {
            int j = 0;
            while (j < m.length) {
                if (i == j && m[i][j] != 0) {
                    return false;
                }
                if (i != j && m[i][j] != 1) {
                    return false;
                }
                j++;
            }
            i++;
        }
        return true;
    }


    //part b
    public static int[][] makeAdjacencyMatrix(ArrayList<String> vertices, String edges) {
        int size = vertices.size();
        int[][] matrix = new int[size][size];

        String[] edgeList = edges.split(" ");

        int i = 0;
        while (i < edgeList.length) {
            String edge = edgeList[i];
            String first = edge.substring(0, 1);
            String second = edge.substring(1, 2);

            int index1 = vertices.indexOf(first);
            int index2 = vertices.indexOf(second);

            matrix[index1][index2] = 1;
            matrix[index2][index1] = 1;

            i++;
        }

        return matrix;
    }
}