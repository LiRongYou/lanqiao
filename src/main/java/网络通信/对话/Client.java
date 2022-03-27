package 网络通信.对话;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //内网穿透：通过别的服务器进行消息转发
            Socket socket = new Socket("localhost", 6000);

            GetMessageThread gmt=new GetMessageThread(socket);
            gmt.start();

            SendMessageThread smt=new SendMessageThread(socket);
            smt.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class GetMessageThread extends Thread {
    Socket socket;
    public GetMessageThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            for (; ; ) {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                //哪个流有：读一行的功能
                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();//阻塞方法
                System.out.println("服务器说：" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
收消息线程
 */
class SendMessageThread extends Thread {
    Socket socket;

    public SendMessageThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            for (; ; ) {
                //发消息：欢迎你
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);//包装
                PrintWriter out = new PrintWriter(osw);
                System.out.println("请输入消息：");
                String msg = sc.next();
//                System.out.println("客户端说："+msg);
                out.println(msg);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}