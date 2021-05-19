package q32;

import java.util.Stack;

/**
 * stack with scanning twice
 */
public class Solution {

    public int longestValidParentheses(String s) {
        boolean[] flagArray = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.empty()) {
                flagArray[stack.pop()] = true;
                flagArray[i] = true;
            }
        }
        int max = 0;
        int sum = 0;
        for (boolean flag : flagArray) {
            if (flag) {
                sum += 1;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")(())())"));
        System.out.println(new Solution().longestValidParentheses("())"));
        System.out.println(new Solution().longestValidParentheses("(()"));
    }
}
