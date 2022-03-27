package 网络通信;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class 客户端 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        String receive = null;

        Socket socket = new Socket("localhost", 8000);
        while (true) {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            //客户端向服务器端发送请求内容
            System.out.println("请输入要向服务器端发送的信息（输入E结束会话）");
            String msg = input.nextLine();
            if (msg.equals("E")) {
                System.out.println("已退出聊天！");
                break;
            }
            dos.writeUTF(msg);
            if ((receive = dis.readUTF()) != null) {
                System.out.println("\n服务器发来的内容 " + receive);
            }
        }
        dos.close();
        dis.close();
        socket.close();
    }
}
