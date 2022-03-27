package IO流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 文件读取 {
    public static void main(String[] args) {
        try {
            FileReader fr =new FileReader("C:\\Users\\ASUS\\Documents\\蓝桥课用软件\\课堂练习\\IO流\\文件读取演示.txt");
            BufferedReader br = new BufferedReader(fr);//包装fr
            String b = "";
            while ((b=br.readLine())!=null){
                System.out.print(b);
            }//一行字符读取
//            int a=0;
//            while ((a=fr.read())!=-1){
//                System.out.print((char)a);
//            }//单个字符读取
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
