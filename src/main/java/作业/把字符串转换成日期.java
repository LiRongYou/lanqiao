package 作业;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者 黎荣右
 * @时间 2021/11/16 22:42
 */
public class 把字符串转换成日期 {
    public static void main(String[] args) {
        Date date = new Date();
        String srt = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(srt);//将Date类型转为字符串"2021-11-16 22:57:34"
        System.out.println(sdf.format(date));//
        try {
            System.out.println(sdf.parse("2021-11-16 22:53:42"));//将字符串"2021-11-16 22:57:34"转为Date类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
