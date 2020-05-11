package q31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        for (; index >= 0; index--) {
            if (nums[index] >= nums[index + 1])
                continue;

            int minGreaterIndex = index + 1;
            for (int i = index + 2; i < nums.length; i++) {
                if (nums[i] > nums[index] && nums[i] < nums[minGreaterIndex])
                    minGreaterIndex = i;
            }
            int temp = nums[minGreaterIndex];
            nums[minGreaterIndex] = nums[index];
            nums[index] = temp;
            Arrays.sort(nums, index + 1, nums.length);
            break;
        }
        if (index == -1)
            Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, 3};
        new Solution().nextPermutation(num);
        for (int n : num)
            System.out.println(n);
    }
}
