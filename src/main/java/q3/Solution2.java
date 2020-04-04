package q3;

/**
 * dynamic programming + recursion
 * RESULT: Time Limit Exceeded
 */
public class Solution2 {
    char[] cs;
    int maxLength = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        this.cs = s.toCharArray();
        recursive(0, cs.length - 1);
        return maxLength;
    }

    public boolean recursive(int left, int right) {
        if (left == right) {
            maxLength = Math.max(maxLength, 1);
            return true;
        }
        boolean leftPart = recursive(left, right - 1);
        boolean rightPart = recursive(left + 1, right);
        if (leftPart && rightPart && cs[left] != cs[right]) {
            maxLength = Math.max(maxLength, right - left + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("bmzckjnrlgqpdqjgnztgqzbjftg"));
    }
}
