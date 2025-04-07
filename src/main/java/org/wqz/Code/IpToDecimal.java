package org.wqz.Code;

public class IpToDecimal {
    public static long ipToLong(String ipAddress) {
        String[] ipParts = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            int part = Integer.parseInt(ipParts[i]);
            result = result << 8 | part;
        }
        return result;
    }

    public static void main(String[] args) {
        String ip = "10.0.3.193";
        long decimal = ipToLong(ip);
        System.out.println("IP 地址 " + ip + " 转换为十进制整数是: " + decimal);
    }
}    