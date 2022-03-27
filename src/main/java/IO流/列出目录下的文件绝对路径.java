package IO流;

import java.io.*;

public class 列出目录下的文件绝对路径 {
    public static void main(String[] args) throws IOException {
        // 1：根据给定的路径创建一个File对象
        File srcFile = new File("C:\\Users\\ASUS\\Music\\本地音乐");
        File f = new File("C:\\Users\\ASUS\\Music\\本地音乐\\mp3路径.list");
        BufferedWriter bw= new BufferedWriter(new FileWriter(f));
        // 3：获取给定的File目录下所有的文件或者目录的File数组
        File[] fileArray = srcFile.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
        // 4：遍历该File数组，得到每一个File对象
        if (fileArray != null) {
            for (File file : fileArray) {//增强for循环
                // 5：判断该File对象是否是目录
                if (file.isDirectory()==false) {//测试此抽象路径名表示的文件是否是一个目录。
                    if(file.getAbsolutePath().endsWith("mp3")){
                    bw.write(file.getAbsolutePath());
                    bw.newLine();
                    System.out.println(file.getAbsolutePath());//返回此抽象路径名的绝对路径名字符串。
                }}
            }
            bw.close();
        }
    }
}

