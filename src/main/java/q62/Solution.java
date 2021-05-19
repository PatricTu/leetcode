package q62;

/**
 * Permutation and Combination
 *
 */
public class Solution {

    private int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17};

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return (int) divideWithoutOverflow(m, m + n - 2, 2, n - 1);
    }

    private long divideWithoutOverflow(int start, int end, int divideStart, int divideEnd) {
        long multi = 1;
        long divide = 1;
        int i = start;
        int j = divideStart;
        while (i <= end || j <= divideEnd) {
            if (i <= end) {
                multi *= i++;
            }
            if (j <= divideEnd) {
                divide *= j++;
            }
            for (int prime : primes) {
                while (true) {
                    if (multi % prime == 0 && divide % prime == 0) {
                        multi /= prime;
                        divide /= prime;
                    } else {
                        break;
                    }
                }
            }
        }
        return multi / divide;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
        System.out.println(new Solution().uniquePaths(3, 3));
        System.out.println(new Solution().uniquePaths(10, 10));
        System.out.println(new Solution().uniquePaths(51, 9));
    }
}
