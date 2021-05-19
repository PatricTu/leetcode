package q41;

/**
 * swap in place
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int last = nums[i];
            nums[i] = 0;
            while (true) {
                if (last <= 0 || last > nums.length || last == nums[last - 1]) {
                    break;
                }
                int temp = nums[last - 1];
                nums[last - 1] = last;
                last = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{}));
        System.out.println(new Solution().firstMissingPositive(new int[]{1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
