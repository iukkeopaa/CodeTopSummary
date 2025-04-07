package org.wqz.Code.PointInTriangle;

class PointInTriangleByArea {
    // 计算由三个点 (x1, y1), (x2, y2), (x3, y3) 构成的三角形的面积
    public static double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    // 判断点 (x, y) 是否在由 (x1, y1), (x2, y2), (x3, y3) 构成的三角形内
    public static boolean isPointInTriangle(double x, double y, double x1, double y1, double x2, double y2, double x3, double y3) {
        // 计算原三角形的面积
        double areaABC = calculateArea(x1, y1, x2, y2, x3, y3);

        // 计算三个小三角形的面积
        double areaPAB = calculateArea(x, y, x1, y1, x2, y2);
        double areaPBC = calculateArea(x, y, x2, y2, x3, y3);
        double areaPCA = calculateArea(x, y, x3, y3, x1, y1);

        // 判断面积之和是否等于原三角形的面积
        return Math.abs(areaABC - (areaPAB + areaPBC + areaPCA)) < 1e-9;
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