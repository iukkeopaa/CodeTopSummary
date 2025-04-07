package org.wqz.Code;

public class ArabicToChinese3 {
    private static final String[] CHINESE_NUMBERS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CHINESE_UNITS = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String convert(int num) {
        if (num == 0) {
            return CHINESE_NUMBERS[0];
        }
        StringBuilder result = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
            result.append("负");
        }
        String numStr = String.valueOf(num);
        int length = numStr.length();
        boolean zeroFlag = false;
        for (int i = 0; i < length; i++) {
            int digit = numStr.charAt(i) - '0';
            int unitIndex = length - i - 1;
            if (digit == 0) {
                zeroFlag = true;
                if (unitIndex % 4 == 0) {
                    result.append(CHINESE_UNITS[unitIndex]);
                }
            } else {
                if (zeroFlag) {
                    result.append(CHINESE_NUMBERS[0]);
                    zeroFlag = false;
                }
                result.append(CHINESE_NUMBERS[digit]);
                result.append(CHINESE_UNITS[unitIndex]);
            }
        }
        // 去除末尾多余的零
        while (result.length() > 1 && result.charAt(result.length() - 1) == '零') {
            result.deleteCharAt(result.length() - 1);
        }
        // 处理一十的情况，简化为十
        if (result.toString().startsWith("一十")) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int num1 = 23045;
        int num2 = -1008;
        int num3 = 10;
        System.out.println(num1 + " 转换为中文: " + convert(num1));
        System.out.println(num2 + " 转换为中文: " + convert(num2));
        System.out.println(num3 + " 转换为中文: " + convert(num3));
    }
}    