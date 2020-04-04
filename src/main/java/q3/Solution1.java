package q3;

import java.util.HashMap;
import java.util.Map;

/**
 * brute force + pruning
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                Character c = s.charAt(j);
                if (map.containsKey(c)) {
                    i = map.get(c);
                    break;
                }
                map.put(c, j);
            }
            length = Math.max(map.size(), length);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcdefgd123456"));
    }
}
