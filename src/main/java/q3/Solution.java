package q3;

import java.util.HashSet;
import java.util.Set;

/**
 * brute force
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                Character c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
            }
            length = Math.max(set.size(), length);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
