package org.wqz.Code;

public class ArabicToChinese2 {
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_UNIT_SECTION = {"", "万", "亿", "万亿"};
    private static final String[] CN_UNIT = {"", "十", "百", "千"};

    public static String arabicToChinese(long num) {
        if (num == 0) {
            return CN_NUM[0];
        }

        StringBuilder result = new StringBuilder();
        int unitSectionIndex = 0;
        boolean zero = true;

        while (num > 0) {
            long section = num % 10000;
            if (section != 0) {
                if (!zero) {
                    result.insert(0, CN_NUM[0]);
                }
                result.insert(0, CN_UNIT_SECTION[unitSectionIndex]);
                result.insert(0, sectionToChinese(section));
                zero = false;
            } else {
                if (!zero) {
                    result.insert(0, CN_UNIT_SECTION[unitSectionIndex]);
                }
                zero = true;
            }
            num /= 10000;
            unitSectionIndex++;
        }

        // 处理以一十开头的情况，如 10 输出 十，而不是 一十
        if (result.length() >= 2 && result.substring(0, 2).equals("一十")) {
            result.delete(0, 1);
        }

        return result.toString();
    }

    private static String sectionToChinese(long section) {
        StringBuilder sectionResult = new StringBuilder();
        int unitIndex = 0;
        boolean zero = true;

        while (section > 0) {
            int digit = (int) (section % 10);
            if (digit == 0) {
                if (!zero) {
                    sectionResult.insert(0, CN_NUM[0]);
                    zero = true;
                }
            } else {
                if (zero && sectionResult.length() > 0) {
                    sectionResult.insert(0, CN_NUM[0]);
                }
                sectionResult.insert(0, CN_UNIT[unitIndex]);
                sectionResult.insert(0, CN_NUM[digit]);
                zero = false;
            }
            section /= 10;
            unitIndex++;
        }

        return sectionResult.toString();
    }

    public static void main(String[] args) {
        long num = 123456789;
        System.out.println(arabicToChinese(num));
    }
}    