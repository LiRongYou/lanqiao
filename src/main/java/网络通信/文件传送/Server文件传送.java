package 网络通信.文件传送;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server文件传送 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedOutputStream out = null;
        try {
            ServerSocket ss = new ServerSocket(22);
            Socket socket = ss.accept();
            OutputStream os = socket.getOutputStream();
            out = new BufferedOutputStream(os);

            /*
            发送文件，先读本机的一个文件，再写（发）
             */
            fis = new FileInputStream("C:\\Users\\ASUS\\Desktop\\新建 文本文档.txt");
            byte buff[] = new byte[1024];
            int a = 0;
            while ((a = fis.read(buff)) != -1) {
                out.write(buff, 0, a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}