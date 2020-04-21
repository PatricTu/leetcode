package q13;

public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                result += 1000;
            } else if (c == 'D') {
                result += 500;
            } else if (c == 'C') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D')) {
                    result -= 100;
                } else {
                    result += 100;
                }
            } else if (c == 'L') {
                result += 50;
            } else if (c == 'X') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'C' || s.charAt(i + 1) == 'L')) {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (c == 'V') {
                result += 5;
            } else if (c == 'I') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V')) {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
