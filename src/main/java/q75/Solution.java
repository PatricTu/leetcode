package q75;

import common.PrintUtil;

public class Solution {
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if (i == 0) {
                a++;
            } else if (i == 1) {
                b++;
            }
        }
        for (int i = 0; i < a; i++) {
            nums[i] = 0;
        }
        for (int i = a; i < a + b; i++) {
            nums[i] = 1;
        }
        for (int i = a + b; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        new Solution().sortColors(nums);
        PrintUtil.printArray(nums);
    }
}
