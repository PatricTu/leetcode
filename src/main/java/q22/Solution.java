package q22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        recursive("", n, n);
        return this.result;
    }

    private void recursive(String str, int lLeft, int rLeft) {
        if (rLeft == 0) {
            result.add(str);
            return;
        }
        if (lLeft > 0)
            recursive(str + "(", lLeft - 1, rLeft);
        if (rLeft > lLeft)
            recursive(str + ")", lLeft, rLeft - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
