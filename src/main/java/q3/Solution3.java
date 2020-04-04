package q3;

/**
 * dynamic programming + iteration with 2-dimensional array
 * RESULT: Memory Limit Exceeded
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int maxLength = 0;
        boolean[][] isNonRepeatingStr = new boolean[s.length()][s.length()];
        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (left == right) {
                    maxLength = Math.max(maxLength, 1);
                    isNonRepeatingStr[left][right] = true;
                    continue;
                }
                if (isNonRepeatingStr[left][right - 1] && isNonRepeatingStr[left + 1][right] && s.charAt(left) != s.charAt(right)) {
                    maxLength = Math.max(maxLength, right - left + 1);
                    isNonRepeatingStr[left][right] = true;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("bmzckjnrlgqpdqjgnztgqzbjftg"));
    }
}
