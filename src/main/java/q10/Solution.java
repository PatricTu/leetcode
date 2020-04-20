package q10;

/**
 * top-down: recursive DFS
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        return recursive(s, p, 0, 0);
    }

    private boolean recursive(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        boolean isNextStar = pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*';
        boolean match = sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex));
        if (isNextStar) {
            return recursive(s, p, sIndex, pIndex + 2) || (match && recursive(s, p, sIndex + 1, pIndex));
        } else {
            return match && recursive(s, p, sIndex + 1, pIndex + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", ".*a*a"));
    }
}
