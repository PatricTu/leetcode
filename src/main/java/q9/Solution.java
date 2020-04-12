package q9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = Integer.toString(x);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12393210));
    }
}
