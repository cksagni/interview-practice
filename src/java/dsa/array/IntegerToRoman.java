package dsa.array;

import java.util.Objects;

public class IntegerToRoman {

    public String intToRoman(int num){
        StringBuilder roman = new StringBuilder();
        int[] intValue = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValue = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < intValue.length; i++){
            while (num >= intValue[i]){
                roman.append(romanValue[i]);
                num -= intValue[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(new IntegerToRoman().intToRoman(3749), "MMMDCCXLIX"));
        System.out.println(Objects.equals(new IntegerToRoman().intToRoman(58), "LVIII"));
    }
}
