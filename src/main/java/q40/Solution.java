package q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * sort -> DFS
 * TODO
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recursive(candidates, target, 0, new LinkedList<>());
    }

    private List<List<Integer>> recursive(int[] candidates, int target, int index, List<Integer> walked) {
        List<List<Integer>> result = new LinkedList<>();
        if (target < 0) {
            return result;
        }
        if (target == 0) {
            result.add(new ArrayList<>(walked));
            return result;
        }
        int last = 0;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == last)
                continue;
            walked.add(candidates[i]);
            result.addAll(recursive(candidates, target - candidates[i], i + 1, walked));
            walked.remove(walked.size() - 1);
            last = candidates[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
