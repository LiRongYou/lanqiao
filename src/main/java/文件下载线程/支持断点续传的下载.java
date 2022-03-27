package 文件下载线程;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class 支持断点续传的下载 {
    public   static   void  main(String[] args){
        // 定义httpURLConnection ,初始为null
        HttpURLConnection hc = null;
        URL url = null;
        String tempFileName = "1.zip";
        String sUrl = "https://dldir1.qq.com/qqfile/qq/PCQQ9.5.6/QQ9.5.6.28129.exe";

        String fileName=sUrl.substring(sUrl.lastIndexOf("/")+1);
        String fileNamePath = "C:\\Users\\ASUS\\Desktop\\"+fileName;

        long beginPos = 0;
        long fileLength = 0;
        int num = 0;
        boolean isFinish = false;
        boolean isFirst = true;
        while (!isFinish && num <= 3) {
            try {
                url = new URL(sUrl);
                hc = (HttpURLConnection) url.openConnection();
                // 定义从beginPos位置处开始
                hc.setRequestProperty("User-Agent", "Java/1.4.2");
                hc.setRequestProperty("RANGE", "bytes="
                        + beginPos + "-");
                // 定义输入流
                InputStream instream = hc.getInputStream();

                if (isFirst) {
                    fileLength = getFileLength(hc);
                    isFirst = false;
                }

                // 创建这个文件输出流
                RandomAccessFile ras = new RandomAccessFile(tempFileName, "rw");
                ras.seek(beginPos);

                // 定义一个大小为1024的字节数组
                byte[] buf = new byte[1024];

                int len = instream.read(buf, 0, 1024);

                // 循环读入字节，然后写到文件输出流中
                while (len > 0) {
                    beginPos += len;
                    ras.write(buf, 0, len);
                    len = instream.read(buf, 0, 1024);
                }

                ras.close();
                if (beginPos >= fileLength) {
                    isFinish = true;
                }

            } catch (MalformedURLException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                num++;
                hc.disconnect();
            }
        }

    }

    /**
     * 从HttpURLConnection中得到文件长度，此HttpURLConnection为已经开启连接后的状态
     *
     * @param hc
     * @return long
     */
    private   static   long  getFileLength(HttpURLConnection hc)  {
        long nFileLength = -1;
        for (int i = 1;; i++) {
            String sHeader = hc.getHeaderFieldKey(i);
            if (sHeader != null) {
                if (sHeader.equals("Content-Length")) {
                    nFileLength = Long.parseLong(hc.getHeaderField(sHeader));
                    break;
                }
            } else {
                break;
            }
        }

        return nFileLength;
    }
}
