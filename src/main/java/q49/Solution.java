package q49;

import java.util.*;

/**
 * count char
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            String key = genKey(str);
            if (resultMap.containsKey(key)) {
                resultMap.get(key).add(str);
            } else {
                List<String> s = new LinkedList<>();
                s.add(str);
                resultMap.put(key, s);
            }
        }
        List<List<String>> resultList = new ArrayList<>(resultMap.size());
        resultList.addAll(resultMap.values());
        return resultList;
    }

    private String genKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            result.append(i + 'a');
            result.append(count[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new Solution().groupAnagrams(new String[]{""}));
        System.out.println(new Solution().groupAnagrams(new String[]{"a"}));
    }
}
