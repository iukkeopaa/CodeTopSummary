package org.wqz.Code;

import java.util.Scanner;
import java.util.Stack;

public class MaxProductInterval2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int maxProduct = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int minVal = arr[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int right = i;
                int sum = prefixSum[right] - prefixSum[left];
                int product = minVal * sum;
                maxProduct = Math.max(maxProduct, product);
            }
            stack.push(i);
        }
        System.out.println(maxProduct);
    }
}    