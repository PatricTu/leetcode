package q3;

/**
 * dynamic programming + iteration with 1-dimensional array
 */
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int maxLength = 0;
        boolean[] lastRow = null;
        for (int left = s.length() - 1; left >= 0; left--) {
            boolean[] currentRow = new boolean[s.length() - left];
            for (int right = left; right < s.length(); right++) {
                if (left == right) {
                    maxLength = Math.max(maxLength, 1);
                    currentRow[right - left] = true;
                } else if (currentRow[right - left - 1] && lastRow[right - left - 1] && s.charAt(left) != s.charAt(right)) {
                    currentRow[right - left] = true;
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
            lastRow = currentRow;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().lengthOfLongestSubstring(" "));
    }
}
