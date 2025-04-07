package org.wqz.Code.WoodCutting;

import java.util.Scanner;

public class WoodCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取 n 和 k
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] woods = new int[n];
        int maxLength = 0;
        // 读取木头长度数组，并找出最大长度
        for (int i = 0; i < n; i++) {
            woods[i] = scanner.nextInt();
            maxLength = Math.max(maxLength, woods[i]);
        }
        scanner.close();

        // 二分查找最大的 m
        int left = 1, right = maxLength;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCut(woods, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    // 检查是否能截出至少 k 个长度为 m 的木块
    private static boolean canCut(int[] woods, int m, int k) {
        int count = 0;
        for (int wood : woods) {
            count += wood / m;
        }
        return count >= k;
    }
}    