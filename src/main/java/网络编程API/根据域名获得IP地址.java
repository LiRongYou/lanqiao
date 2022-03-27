package 网络编程API;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class 根据域名获得IP地址 {
    public static void main(String[] args) {
        InetAddress showIP = null;

        while (true) {
            System.out.println("1进入程序 0退出程序");
            Scanner input = new Scanner(System.in);

            int choose = input.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("输入要查询的IP地址的域名：");
                    String name = input.next();
                    try {
                        showIP = InetAddress.getByName(name);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                        System.out.println("域名输入错误");
                    }
                    System.out.println("域名：" + name + " 对应的IP地址为" + showIP.getHostAddress());
                    break;
                case 0:
                    System.out.println("感谢使用");
                    System.exit(0);
                    break;
            }
        }
    }
}
