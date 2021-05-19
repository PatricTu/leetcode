package q30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * brute-force
 * Time Limit Exceeded
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0)
            return result;
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < s.length(); i++) {
            if (match(s.substring(i), wordsList))
                result.add(i);
        }
        return result;
    }

    private static boolean match(String s, List<String> words) {
        if (words.size() == 0)
            return true;
        for (String word : words) {
            if (s.startsWith(word)) {
                List<String> remainWords = new ArrayList<>(words);
                remainWords.remove(word);
                if (match(s.substring(word.length()), remainWords)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(new Solution().findSubstring("gooderbestgood", new String[]{"good", "best", "gooder"}));
        System.out.println(new Solution().findSubstring("foooo", new String[]{}));

    }
}
