package 文件下载线程;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class 文件下载作业 {
    public static void main(String[] args) {
        int threadNum=6;
        String filePath="C:\\Users\\ASUS\\Desktop\\";
        try {
            String address="https://dldir1.qq.com/qqfile/qq/PCQQ9.5.6/QQ9.5.6.28129.exe";
            URL url=new URL(address);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in=connection.getInputStream();
            //long fileSize=connection.getContentLengthLong();
            int fileSize=connection.getContentLength();//2047MB（2G文件大小）
            System.out.println("文件大小："+fileSize);

            /*
            先在硬盘上创建一个空文件
             */
            String fileName=address.substring(address.lastIndexOf("/")+1);
//            File file=new File("C:\\Users\\ASUS\\Desktop\\"+fileName);
//            RandomAccessFile raf=new RandomAccessFile(file,"rwd");//读、写、删除
//            raf.setLength(fileSize);
//            raf.close();


            /*
            加入开5个线程
             */
            int size=fileSize/threadNum;
            /*
            前4个线程，每个线程负责下载40804866字节，最后一个线程负责下载40804866+1
            起始位置        结束位置
            0-------------40804866
            40804867------81609732
            81609733------122414598
            122414599-----163219464
            163219465-----最后
             */
            for(int i=0;i<threadNum;i++){
                int startPos= i* size;
                int endPos;
                if(i==threadNum-1){
                    endPos=0;
                }else{
                    endPos=startPos+size;
                }
                if(startPos!=0){
                    startPos++;
                }
                System.out.println(startPos+"------"+endPos);
                new Downloaders(filePath,fileName,startPos,endPos,url,i,threadNum).start();//线程启动
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
下载器
继承是一个法宝
构造5个Downloader的对象（5个线程）
 */
class Downloaders extends Thread{
    int startPos;//开始字节
    int endPos;//结束字节
    int i;
    int threadNum;//线程数量
    URL url;
    String filePath;//文件路径
    String fileName;//文件名字
    public Downloaders(String filePath,String fileName,int startPos,int endPos,URL url,int i,int threadNum){
        this.fileName=fileName;
        this.startPos=startPos;
        this.endPos=endPos;
        this.url=url;
        this.i=i;
        this.threadNum=threadNum;
        this.filePath=filePath;
    }
    public void run(){
        try{
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if(endPos!=0){
                connection.setRequestProperty("RANGE","bytes="+startPos+"-"+endPos);
            }else{
                connection.setRequestProperty("RANGE","bytes="+startPos+"-");
            }
//            RandomAccessFile raf=new RandomAccessFile("C:\\Users\\ASUS\\Desktop\\"+fileName,"rwd");
//            raf.seek(startPos);
//            File f = new File("C:\\Users\\ASUS\\Desktop\\"+fileName);
//            FileOutputStream fos = new FileOutputStream(f);
//            fos.write(startPos);

            // 定义输入流
            //一个线程创建创建一个文件
            InputStream in=connection.getInputStream();
            BufferedInputStream bis=new BufferedInputStream(in);
            FileOutputStream out = new FileOutputStream(filePath+i+fileName);
            byte buff[]=new byte[1024*8];
            int a=0;
            while((a=bis.read(buff))!=-1){
                out.write(buff,0,a);
            }
            out.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mergeFiles();
    }

    /*
    合并文件
     */
    public  void mergeFiles() {
        System.out.println("合并文件 start......");
        OutputStream out = null;

        try {
            out = new FileOutputStream(filePath+fileName);
            for (int i = 0; i <= threadNum; i++) {
                InputStream is = new FileInputStream(filePath+i+fileName);
                byte[] bytes = new byte[2048*5];
                int read = 0;
                while ((read = is.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                    out.flush();
                }
                    is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("合并文件 end......");
    }
}