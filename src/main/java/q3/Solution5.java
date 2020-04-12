package q3;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 * time complexity: O(n)
 */
public class Solution5 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().lengthOfLongestSubstring("234563789"));
    }
}
