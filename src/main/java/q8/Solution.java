package q8;

public class Solution {
    public int myAtoi(String str) {
        int result = 0;
        boolean digitShowed = false;
        boolean signShowed = false;
        boolean isPositive = true;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int n = c - '0';
                if (isPositive) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && n > 7))
                        return Integer.MAX_VALUE;
                    else
                        result = result * 10 + n;
                } else {
                    if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && n > 8))
                        return Integer.MIN_VALUE;
                    else
                        result = result * 10 - n;
                }
                digitShowed = true;
            } else if (digitShowed || signShowed) {
                break;
            } else {
                if (c == ' ') {
                    continue;
                }
                if (c == '-' || c == '+') {
                    signShowed = true;
                    isPositive = c == '+';
                    continue;
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("   -+45"));
    }
}
