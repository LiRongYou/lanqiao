package 网络通信.对话;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
服务器：提供服务器的一方
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6000);
            while(true){
                System.out.println("等待客户端连接");
                Socket socket = ss.accept();//阻塞函数：程序执行到这里，就停住，直到有人连接该电脑的8888端口，程序才会继续运行下去
                System.out.println("有客户端连接了");

                SendMessage sm = new SendMessage(socket);
                sm.start();//启动线程

                GetMessage gm=new GetMessage(socket);
                gm.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GetMessage extends Thread {
    Socket socket;
    public GetMessage(Socket socket) {
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
                System.out.println("客户端说：" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
收消息线程
 */
class SendMessage extends Thread {
    Socket socket;

    public SendMessage(Socket socket) {
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
//                System.out.println("服务器说："+msg);
                out.println(msg);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}