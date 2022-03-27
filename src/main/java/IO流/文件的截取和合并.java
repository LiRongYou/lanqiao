package IO流;

import java.io.*;

public class 文件的截取和合并 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\ASUS\\Music\\本地音乐\\mp3路径.list");//让用户从控制台输入指定的路径
        File file = new File("C:\\Users\\ASUS\\Music\\本地音乐");
        File files[] = file.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".mp3")) {
                String absolutePath = f.getAbsolutePath();//绝对路径，包含路径+文件名fw.write(absolutePath);
                fw.write(absolutePath);
                fw.write('\n');
            }
        }
        fw.close();

        FileReader fr=new FileReader("C:\\Users\\ASUS\\Music\\本地音乐\\mp3路径.list");
        BufferedReader br=new BufferedReader(fr);
        String fileName="";
        FileOutputStream fos=new FileOutputStream("C:\\Users\\ASUS\\Music\\本地音乐\\merge.mp3");
        while((fileName= br.readLine())!=null) {
            FileInputStream fis = new FileInputStream(fileName);
            byte buff[] = new byte[1024];
            int a = 0;
            while ((a = fis.read(buff)) != -1) {
                fos.write(buff, 0, a);
            }
            fis.close();
        }
        fos.close();
        }
    }




