package q7;

public class Solution {
    public int reverse(int x) {
        int result = 0;
        int lastResult = result;
        for (int i = 0; i < 10; i++) {
            lastResult = result;
            result = result * 10 + (x % 10);
            x = x / 10;
            if (x == 0)
                break;
        }
        // is this right way to judge whether overflow happened ???
        if (result / 10 == lastResult)
            return result;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123456789));
    }
}
