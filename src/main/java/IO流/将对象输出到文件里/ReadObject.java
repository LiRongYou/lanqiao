package IO流.将对象输出到文件里;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {

    public static void main(String[] args) {
        Student stu3 = null;
        Student stu4 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\ASUS\\IdeaProjects\\蓝桥课作业\\Object.txt"));
            stu3=(Student)ois.readObject();
            System.out.println("名字为：" + stu3.getName() + "\n年龄为：" + stu3.getAge());

            stu4=(Student)ois.readObject();
            System.out.println("名字为：" + stu4.getName() + "\n年龄为：" + stu4.getAge());
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
