package q12;

public class Solution {
    public String intToRoman(int num) {
        String[][] roman = new String[][]{{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; num > 0; i++) {
            sb.insert(0, roman[i][num % 10]);
            num /= 10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
    }
}
