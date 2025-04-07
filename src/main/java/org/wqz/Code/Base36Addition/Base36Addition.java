package org.wqz.Code.Base36Addition;

public class Base36Addition {
    public static String add36BaseNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? getValue(num1.charAt(i--)) : 0;
            int digit2 = (j >= 0) ? getValue(num2.charAt(j--)) : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 36;
            sum = sum % 36;

            result.append(getChar(sum));
        }

        return result.reverse().toString();
    }

    private static int getValue(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        } else {
            return Character.toLowerCase(c) - 'a' + 10;
        }
    }

    private static char getChar(int value) {
        if (value < 10) {
            return (char) (value + '0');
        } else {
            return (char) (value - 10 + 'a');
        }
    }

    public static void main(String[] args) {
        String num1 = "1b";
        String num2 = "2x";
        String sum = add36BaseNumbers(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }
}    