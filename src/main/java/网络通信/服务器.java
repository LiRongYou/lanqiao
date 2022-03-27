package 网络通信;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class 服务器 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有用户连接进来......");
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}

class ServerThread extends Thread {
    Socket socket;
    Scanner input = new Scanner(System.in);

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
            String str = null;

            while (true) {
                //服务器向客户端发送响应内容
                System.out.println("请输入要向客户端发送的信息：");
                String msg = input.nextLine();
                dos.writeUTF(msg);
                System.out.println();
                if ((str = dis.readUTF()) != null) {
                    if (str.equals("E")) {
                        break;
                    }
                    System.out.println("客户端发来的内容：" + str);
                }
            }
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" 客 户 端 " + socket.getInetAddress().getHostAddress()
                    + ":" + socket.getPort() + "退出！");
        }

    }
}