package q45;

/**
 * DP
 * f(n) = 1 + min{f(i)  n+1 <= i <= n+nums[n]}
 */
public class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] result = new int[nums.length];
        result[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            boolean moveable = false;
            for (int j = i + 1; j <= i + nums[i] && j < length; j++) {
                if (result[j] != -1) {
                    min = Math.min(min, result[j]);
                    moveable = true;
                }
            }
            if (moveable) {
                result[i] = min + 1;
            } else {
                result[i] = -1;
            }
        }
        return result[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution().jump(new int[]{2,3,0,1,4}));
        System.out.println(new Solution().jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}
