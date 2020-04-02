package q20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || !match(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[]({)}"));
    }
}
