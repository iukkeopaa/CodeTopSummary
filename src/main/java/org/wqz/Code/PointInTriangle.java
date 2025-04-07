package org.wqz.Code;

class PointInTriangle {
    // 计算向量叉积
    public static double crossProduct(double x1, double y1, double x2, double y2) {
        return x1 * y2 - x2 * y1;
    }

    // 判断点 (x, y) 是否在由 (x1, y1), (x2, y2), (x3, y3) 构成的三角形内
    public static boolean isPointInTriangle(double x, double y, double x1, double y1, double x2, double y2, double x3, double y3) {
        double cp1 = crossProduct(x - x1, y - y1, x2 - x1, y2 - y1);
        double cp2 = crossProduct(x - x2, y - y2, x3 - x2, y3 - y2);
        double cp3 = crossProduct(x - x3, y - y3, x1 - x3, y1 - y3);

        boolean hasNeg = (cp1 < 0) || (cp2 < 0) || (cp3 < 0);
        boolean hasPos = (cp1 > 0) || (cp2 > 0) || (cp3 > 0);

        return !(hasNeg && hasPos);
    }

    public static void main(String[] args) {
        double x = 2.0;
        double y = 2.0;
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 4.0;
        double y2 = 0.0;
        double x3 = 0.0;
        double y3 = 4.0;

        boolean result = isPointInTriangle(x, y, x1, y1, x2, y2, x3, y3);
        System.out.println("点 (" + x + ", " + y + ") 是否在三角形内: " + result);
    }
}    