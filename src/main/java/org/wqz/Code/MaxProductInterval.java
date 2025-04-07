package org.wqz.Code;

import java.util.Scanner;

public class MaxProductInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取数组长度
        int n = scanner.nextInt();
        int[] arr = new int[n];
        // 读取数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int maxProduct = 0;
        // 遍历所有可能的区间
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j < n; j++) {
                // 更新区间的最小值
                minVal = Math.min(minVal, arr[j]);
                // 更新区间的和
                sum += arr[j];
                // 计算当前区间的乘积
                int product = minVal * sum;
                // 更新最大乘积
                maxProduct = Math.max(maxProduct, product);
            }
        }
        // 输出最大乘积
        System.out.println(maxProduct);
    }
}    