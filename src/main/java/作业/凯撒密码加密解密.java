package 作业;
import java.util.Scanner;
public class 凯撒密码加密解密 {
    /**
     *凯撒密码加密
     * @param str 输入值
     * @param  i 密钥
     */
//     public static void process(String str,int i){
//  //把字符串转为字符数
//  char[] chars = str.toCharArray();
//  StringBuilder sh = new StringBuilder();
//  //对输入值进行位移
//  for (char c : chars) {
//      int asciiCode = c;
//      asciiCode = asciiCode + i;
//      char newchar =(char)asciiCode;
//      sh.append(newchar);
//  }
//  System.out.println("加密后的字符串为："+sh.toString());
// }
    public static String process(String str, int i) {
        //把字符串转为字符数
        char[] chars = str.toCharArray();

        StringBuilder sh = new StringBuilder();
        //对输入值进行位移
        for (char c : chars) {
            int asciiCode = c;
            asciiCode = asciiCode + i;
            char newchar =(char)asciiCode;
            sh.append(newchar);
        }
        return sh.toString();
    }
    /**
     * 凯撒密码解密操作
     * @param srt 输出值
     * @param i 密钥
     */

    public static String decrypt(String srt, int i) {
        //对密文进行解密，生成字符数组
        char[] chars = srt.toCharArray();

        StringBuilder sh = new StringBuilder();
        for (char c : chars) {
            int value= c;
            //对输出值进行位移
            int newvalue = value - i ;
            char result  = (char) newvalue;
            sh.append(result);
        }
        return sh.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要加密的字符串：");
        String str = input.next();
        System.out.println("请输入偏移量：");
        int i = input.nextInt();
        System.out.println("加密后的字符串为："+process(str,i)) ;
        System.out.println("加密后的字符串为："+decrypt(str,i)) ;
    }
}

