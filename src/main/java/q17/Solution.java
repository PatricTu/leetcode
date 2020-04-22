package q17;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new LinkedList<>();
    String digits;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        this.digits = digits;
        recursive(0, "");
        return this.result;
    }

    private void recursive(int index, String str) {
        if (index >= digits.length()) {
            result.add(str);
            return;
        }
        String curLetters = letters[digits.charAt(index) - '2'];
        for (int i = 0; i < curLetters.length(); i++) {
            recursive(index + 1, str + curLetters.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
    }
}
