package org.wqz.Code.CubeRootManual;

public class CubeRootManual {
    public static double cubeRoot(double num) {
        double epsilon = 1e-7;
        double left, right;
        if (num >= 1) {
            left = 0;
            right = num;
        } else if (num >= 0) {
            left = num;
            right = 1;
        } else {
            left = num;
            right = 0;
        }

        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double midCube = mid * mid * mid;
            if (midCube > num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (left + right) / 2;
    }

    public static void main(String[] args) {
        double number = 27;
        double result = cubeRoot(number);
        System.out.println("数字 " + number + " 的立方根是: " + result);
    }
}    