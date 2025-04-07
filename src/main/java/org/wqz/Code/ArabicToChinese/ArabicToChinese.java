package org.wqz.Code.ArabicToChinese;

public class ArabicToChinese {
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String arabicToChinese(int num) {
        if (num == 0) {
            return CN_NUM[0];
        }

        StringBuilder sb = new StringBuilder();
        int unitIndex = 0;
        boolean zero = false;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                if (!zero) {
                    sb.insert(0, CN_NUM[0]);
                    zero = true;
                }
            } else {
                if (zero) {
                    sb.insert(0, CN_NUM[0]);
                    zero = false;
                }
                sb.insert(0, CN_UNIT[unitIndex]);
                sb.insert(0, CN_NUM[digit]);
            }
            num /= 10;
            unitIndex++;
        }

        // 处理特殊情况，如 10 直接输出 十，而不是 一十
        if (sb.length() >= 2 && sb.substring(0, 2).equals("一十")) {
            sb.delete(0, 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 12040;
        System.out.println(arabicToChinese(num));
    }
}    