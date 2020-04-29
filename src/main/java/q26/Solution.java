package q26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
