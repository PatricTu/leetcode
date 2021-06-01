package q76;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 */
public class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            addCharacter(tMap, c);
        }
        int resultLeft = -1;
        int resultRight = s.length() + 1;
        Map<Character, Integer> sMap = new HashMap<>();
        while (left < s.length() && right <= s.length()) {
            if (isRightMap(tMap, sMap)) {
                if (right - left < resultRight - resultLeft) {
                    resultLeft = left;
                    resultRight = right;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    removeCharacter(sMap, s.charAt(left));
                }
                ++left;
            } else {
                if (right >= s.length())
                    break;
                if (tMap.containsKey(s.charAt(right))) {
                    addCharacter(sMap, s.charAt(right));
                }
                ++right;
            }
        }
        if (resultLeft == -1) {
            return "";
        }
        return s.substring(resultLeft, resultRight);
    }

    private void addCharacter(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private void removeCharacter(Map<Character, Integer> map, char c) {
        if (map.get(c) == 1) {
            map.remove(c);
        } else {
            map.put(c, map.get(c) - 1);
        }
    }

    private boolean isRightMap(Map<Character, Integer> aMap, Map<Character, Integer> bMap) {
        for (Map.Entry<Character, Integer> entry : aMap.entrySet()) {
            if (bMap.get(entry.getKey()) == null || entry.getValue() > bMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
    }
}
