package q55;

public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (can[i + j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}
