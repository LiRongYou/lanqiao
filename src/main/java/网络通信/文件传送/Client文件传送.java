package 网络通信.文件传送;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client文件传送 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        BufferedInputStream in = null;
        try {
            Socket socket = new Socket("121.89.196.12", 6000);
            out = new FileOutputStream("C:\\Users\\ASUS\\Desktop\\text.mp3");
            InputStream is = socket.getInputStream();
            in = new BufferedInputStream(is);
            byte buff[] = new byte[1024];
            int a = 0;
            while ((a = in.read(buff)) != -1) {
                out.write(buff, 0, a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
