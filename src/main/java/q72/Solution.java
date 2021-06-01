package q72;

public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    result[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    result[i][j] = i;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, result[i - 1][j - 1] + 1);
                    min = Math.min(min, result[i][j - 1] + 1);
                    min = Math.min(min, result[i - 1][j] + 1);
                    result[i][j] = min;
                }
            }
        }
        return result[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("a", "a"));
        System.out.println(new Solution().minDistance("a", "b"));
    }
}
