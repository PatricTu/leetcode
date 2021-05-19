package q32;

import java.util.Stack;

/**
 * stack with scanning once
 * TODO
 */
public class Solution2 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int lastInvalidIndex = -1;
        int lastSum = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.empty()) {
            } else {
                max = Math.max(max, i + 1 - stack.pop());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestValidParentheses(")(())())"));
        System.out.println(new Solution2().longestValidParentheses("())"));
        System.out.println(new Solution2().longestValidParentheses("(()"));
        System.out.println(new Solution2().longestValidParentheses("(())()"));
        System.out.println(new Solution2().longestValidParentheses("()(()"));
        System.out.println(new Solution2().longestValidParentheses("()()"));
    }
}
