package q91;

/**
 * dp: recursion
 */
public class Solution {
    private String s;
    private int counter = 0;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        this.s = s;
        recursive(0);
        return counter;
    }

    private void recursive(int index) {
        if (index == s.length()) {
            counter++;
            return;
        }
        if (s.charAt(index) == '0')
            return;

        recursive(index + 1);
        if (index < s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')))
            recursive(index + 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("206"));
    }
}
