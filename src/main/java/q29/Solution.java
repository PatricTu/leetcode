package q29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE && dividend != Integer.MIN_VALUE)
            return 0;
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sameSign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        if (!sameSign)
            divisor = -divisor;
        int result = 0;
        if (dividend < 0) {
            while (dividend <= divisor) {
                result++;
                dividend -= divisor;
            }
        } else if (dividend > 0) {
            while (dividend >= divisor) {
                result++;
                dividend -= divisor;
            }
        } else {
            return 0;
        }
        return sameSign ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(-10, 3));
        System.out.println(new Solution().divide(10, -3));
        System.out.println(new Solution().divide(-10, -3));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 1));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, -1));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
