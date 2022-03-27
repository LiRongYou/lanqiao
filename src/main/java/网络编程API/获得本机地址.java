package 网络编程API;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class 获得本机地址 {
    public static void main(String[] args) {
        InetAddress myip = null;
        try {
            myip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //获得地址字符串
        System.out.println(myip.getHostAddress());
    }
}
