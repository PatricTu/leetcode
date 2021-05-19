package q48;

import static common.PrintUtil.printMatrix;

public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - 1 - i; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        new Solution().rotate(matrix);
        printMatrix(matrix);
    }
}
