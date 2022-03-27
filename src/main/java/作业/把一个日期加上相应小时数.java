package 作业;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @作者 黎荣右
 * @时间 2021/11/16 23:01
 */
public class 把一个日期加上相应小时数 {
    public static void main(String[] args) {
        Date date = new Date();//获取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);//修改时间
        calendar.add(calendar.HOUR,1);//日期往后推一个小时
//        calendar.add(calendar.MINUTE,10);//推后10分钟
//        calendar.add(calendar.DATE,1);//推后一天
        date = calendar.getTime();//将修改后的时间赋值
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        System.out.println(dateString);
        System.out.println(calendar.get(calendar.DAY_OF_WEEK_IN_MONTH)+"周");//获得当前日期是当月的第几周
    }
}
