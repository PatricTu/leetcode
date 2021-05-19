package q30;

import java.util.*;

/**
 * brute-force: use map instead of list
 *
 */
public class Solution1 {
    private int wordLength;

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0)
            return result;
        wordLength = words[0].length();
        Map<String, Integer> countMap = getCountMap(words);
        int sumLengthOfWords = getSumLength(words);
        for (int i = 0; i <= s.length() - sumLengthOfWords; i++) {
            if (match(s.substring(i), countMap, words.length))
                result.add(i);
        }
        return result;
    }

    private int getSumLength(String[] words) {
        int sum = 0;
        for (String word : words) {
            sum += word.length();
        }
        return sum;
    }

    private Map<String, Integer> getCountMap(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            addWord2Map(countMap, word);
        }
        return countMap;
    }

    private boolean match(String s, Map<String, Integer> wordMap, int wordCount) {
        if (wordCount == 0)
            return true;
        String firstWord = s.substring(0, wordLength);
        if (wordMap.containsKey(firstWord) && wordMap.get(firstWord) > 0) {
            wordMap.compute(firstWord, (k, v) -> v -= 1);
            boolean isMatch = match(s.substring(wordLength), wordMap, --wordCount);
            wordMap.compute(firstWord, (k, v) -> v += 1);
            return isMatch;
        }
        return false;
    }

    private void addWord2Map(Map<String, Integer> countMap, String word) {
        if (countMap.containsKey(word)) {
            countMap.compute(word, (k, v) -> v += 1);
        } else {
            countMap.put(word, 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution1().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(new Solution1().findSubstring("foooo", new String[]{}));
        System.out.println(new Solution1().findSubstring("aaa", new String[]{"a", "a"}));
    }
}
