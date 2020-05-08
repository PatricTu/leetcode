package q91;

/**
 * dp: iteration
 */
public class Solution1 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] result = new int[s.length()];
        result[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                result[i] = result[i - 1];
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
                result[i] += i >= 2 ? result[i - 2] : 1;
        }
        return result[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numDecodings("012"));
    }
}
