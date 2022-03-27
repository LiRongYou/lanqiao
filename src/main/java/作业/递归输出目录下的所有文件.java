package 作业;
import java.io.File;
import java.io.IOException;

/**
 * @作者 黎荣右
 * @时间 2021/12/2 20:32
 */
public class 递归输出目录下的所有文件 {
    public static void main(String[] args) throws IOException {
        // 1：根据给定的路径创建一个File对象
        File srcFile = new File("C:\\Users\\ASUS\\Documents\\蓝桥课用软件\\课堂练习");

        // 6：调用方法
        getAllFilePath(srcFile);
    }

    // 2：定义一个方法，用于获取给定目录下的所有内容，参数为第1步创建的File对象
    public static void getAllFilePath(File srcFile) throws IOException {
        // 3：获取给定的File目录下所有的文件或者目录的File数组
        File[] fileArray = srcFile.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
        // 4：遍历该File数组，得到每一个File对象
        if (fileArray != null) {
            for (File file : fileArray) {//增强for循环
                // 5：判断该File对象是否是目录
                if (file.isDirectory()) {//测试此抽象路径名表示的文件是否是一个目录。
                    // 5.1：是：递归调用
                    getAllFilePath(file);
                } else {
                    // 5.2：不是：获取绝对路径输出在控制台
                    System.out.println(file.getAbsolutePath());//返回此抽象路径名的绝对路径名字符串。
                }
            }
        }
    }
}
