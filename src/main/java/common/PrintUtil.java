package common;

public class PrintUtil {

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j : ints) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
