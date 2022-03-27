package 文件下载线程;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class 通过java程序去下载文件 {
    public static void main(String[] args) {
        //  定义httpURLConnection ,初始为null
        HttpURLConnection hc  =   null ;
        String address="https://dldir1.qq.com/qqfile/qq/PCQQ9.5.6/QQ9.5.6.28129.exe";
        String fileName=address.substring(address.lastIndexOf("/")+1);
        try   {
            // 打开一个http连接
            URL url = new URL(address);
            hc = (HttpURLConnection) url.openConnection();

            // 定义输入流
            InputStream instream = hc.getInputStream();

            // 创建这个文件输出流
            String tempFileName = "C:\\Users\\ASUS\\Desktop\\"+fileName;
            FileOutputStream fos = new FileOutputStream(tempFileName);

            // 定义一个大小为1024的字节数组
            byte[] buf = new byte[1024*10];

            // 从输入流中读出字节到定义的字节数组
            int len = instream.read(buf, 0, 1024);

            // 循环读入字节，然后写到文件输出流中
            while (len != -1) {
                fos.write(buf, 0, len);
                len = instream.read(buf, 0, 1024);

            }
            fos.flush();
            fos.close();

        }   catch  (Exception e)  {
            System.err.println("下载出错！");
            e.printStackTrace();
        }   finally   {
            if (hc != null)
                hc.disconnect();
        }
    }
}
