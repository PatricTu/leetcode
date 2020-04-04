package q39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * sort -> DFS
 */
public class Solution {

    int[] cand;
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        cand = candidates;
        Arrays.sort(cand);
        recursive(target, 0, new LinkedList<>());
        return result;
    }

    public void recursive(int target, int index, List<Integer> path) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
        } else if (target > 0){
            for (int i = index; i < cand.length && cand[i] <= target; i++) {
                path.add(cand[i]);
                recursive(target - cand[i], i, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{8, 7, 4, 3}, 11));
    }
}
