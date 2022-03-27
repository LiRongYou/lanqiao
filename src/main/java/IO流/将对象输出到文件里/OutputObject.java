package IO流.将对象输出到文件里;

import java.io.*;


public class OutputObject {

    public static void main(String[] args) {
        // 创建对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 19);
        // 创建文件对象
        File file = new File("Object.txt");
        // 创建输出流
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // 根据格式创建字符串
            String obj = "[name='" + s1.getName() + "',age='" + s1.getAge() + "']、[name='" + s2.getName() + "',age='"
                    + s2.getAge() + "']";
            // 写出数据
            bos.write(obj.getBytes());
            // 刷新缓冲区
            bos.flush();

            String b = "";
            while ((b=br.readLine())!=null){
                System.out.print(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}