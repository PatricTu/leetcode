package q78;

import java.util.LinkedList;
import java.util.List;

/**
 * recursive
 */
public class Solution {

    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        return recursive(nums.length - 1);
    }

    public List<List<Integer>> recursive(int index) {
        if (index == -1) {
            List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            return result;
        }
        List<List<Integer>> subResult = recursive(index - 1);
        List<List<Integer>> result = new LinkedList<>(subResult);
        for (List<Integer> subList : subResult) {
            List<Integer> subListWithCur = new LinkedList<>(subList);
            subListWithCur.add(nums[index]);
            result.add(subListWithCur);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
