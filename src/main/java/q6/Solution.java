package q6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s == null)
            return s;

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            int indexL = -i;
            int indexR = i;
            while (indexL < s.length()) {
                if (i != 0 && i != numRows - 1 && indexL >= 0)
                    sb.append(s.charAt(indexL));
                if (indexR < s.length())
                    sb.append(s.charAt(indexR));
                indexL += 2 * (numRows - 1);
                indexR += 2 * (numRows - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 2));
    }
}
