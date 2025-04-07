package org.wqz.Code.StringSubtraction;

public class StringSubtraction {
    public static String subtract(String num1, String num2) {
        // 确定哪个数更大
        if (isGreater(num2, num1)) {
            return "-" + subtract(num2, num1);
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
            i--;
            j--;
        }

        // 移除前导零
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    private static boolean isGreater(String num1, String num2) {
        if (num1.length() != num2.length()) {
            return num1.length() > num2.length();
        }
        return num1.compareTo(num2) > 0;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        System.out.println(subtract(num1, num2));
    }
}    