package org.wqz.Code;

public class IpToDecimal2 {
    public static long ipToLong(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        // 将每段 IP 地址转换为整数，并进行位运算
        long first = Long.parseLong(parts[0]) << 24;
        long second = Long.parseLong(parts[1]) << 16;
        long third = Long.parseLong(parts[2]) << 8;
        long fourth = Long.parseLong(parts[3]);

        // 通过或运算组合各段
        return first | second | third | fourth;
    }

    public static void main(String[] args) {
        String ip = "10.0.3.193";
        long decimal = ipToLong(ip);
        System.out.println("IP 地址 " + ip + " 转换为十进制整数是: " + decimal);
    }
}    