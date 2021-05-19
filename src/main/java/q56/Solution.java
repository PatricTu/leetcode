package q56;

import common.PrintUtil;

/**
 * TODO
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        return null;
    }

    public static void main(String[] args) {
        PrintUtil.printMatrix(new Solution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        PrintUtil.printMatrix(new Solution().merge(new int[][]{{1,4},{4,5}}));
        PrintUtil.printMatrix(new Solution().merge(new int[][]{{1,4},{5,6}}));
    }
}
