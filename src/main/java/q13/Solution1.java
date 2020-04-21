package q13;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        int prev = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int cValue = map.get(c);
            result += cValue;
            if (cValue > prev) {
                result -= prev * 2;
            }
            prev = cValue;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().romanToInt("MCMXCIV"));
    }
}
