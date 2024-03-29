package q64;

/**
 * DP
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                } else if (i == 0) {
                    result[i][j] = result[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    result[i][j] = result[i - 1][j] + grid[i][j];
                } else {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
                }
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
