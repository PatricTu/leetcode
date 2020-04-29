package q27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int n : nums) {
            if (n != val) {
                nums[index++] = n;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
