package 作业;

/**
 * @作者 黎荣右
 * @时间 2021/11/16 20:45
 */
public class 字符串常用方法 {
    public static void main(String[] args) {
        String s1 = "桂林电子科技大学";
        String s2 = "桂林";
        String s3 = " Hallo,World";
        System.out.println(s1.charAt(1));//charAt(int index):获取指定索引处的字符
        System.out.println(s1.length());//length():获取字符串的长度
        System.out.println(s1.indexOf("桂林"));//indexOf(String str):获取str在字符串对象中第一次出现的索引
        System.out.println(s1.indexOf("科技", 2));//indexOf(String str):获取str在字符串对象中第一次出现的索引，从fromlndex处开始
        System.out.println(s1.equalsIgnoreCase(s2));//不区分大小写
        System.out.println(s1.replace("桂林", "华北"));//将新字符串替换旧字符串
        System.out.println(s1.startsWith("桂林"));//判断字符串是否以指定前缀开始
        System.out.println(s1.endsWith("大学"));//判断字符串是否以指定后缀结束
        System.out.println(s3.toUpperCase());//将字符转换为大写
        System.out.println(s3.toLowerCase());//将字符转换为小写
        System.out.println(s1.substring(2));//返回一个从beginIndex开始到结尾的新字符串
        System.out.println(s1.substring(2, 5));//返回一个从beginIndex开始到endIndex结尾的新字符串
        System.out.println(s3.trim());//忽略原字符串前后空格
        System.out.println(String.valueOf(123));//转换为字符串
        String[] split = s3.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);//指定分隔符，返回分隔后的字符串数组
        }
    }
}