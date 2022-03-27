package 作业;

import java.util.Scanner;

/**
 * @作者 黎荣右
 * @时间 2021/11/16 20:06
 */
public class 阿拉伯数字转换成中文 {
    public static void main(String[] args) {
        System.out.println("输入要转换的阿拉伯数字：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        //将输入的字符串转换成char数组
        char []numChar = str.toCharArray();//将字符串强制转换成char数组
        String[] chinese = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] unit = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };//数位
        StringBuffer zh=new StringBuffer();
        //获取用户输入的字符串长度
        int size=numChar.length;
        //遍历char数组
        for (int i = 0; i < numChar.length; i++) {
            //将用户输入的数字拿出来
            //比如用户输入1234数字
            //numChar['1','2','3','4']
            //numChar[0]
            //因此拿到的阿拉伯数字就是num=1
            int num = Integer.parseInt(String.valueOf(numChar[i]));//先将数组转换为字符串，再转换为int型
            //因为咱们的汉字和数组下标一一对应，所以可以直接将拿到的阿拉伯数字作为中文数组的下标取汉字
            //因此这时chinese[1]对应的就是汉字"一"
            //再就是打印一个汉字数字就加一个单位
            //通过观察可以找出阿拉伯数字和单位的关系，关系如下
            //1234长度为4，对应到计数单位数组4索引是”万”单位
            //1是千单位，以4-1就可以得到计数单位数组的"千”单位
            //4-1=3|unit[3]拿第一个千
            //4-2=2|unit[2]拿第二个百
            //4-3=1|unit[1]拿第三个十
            if(i!=0){
                //数组长度-i
                //上述对应成代码就是 size-i
                //因为计数单位数组省略了"个”单位
                //所以需要减去1，取出所有单位
                //单位+数字|千二百三十四
                zh.append(unit[size-i-1]+chinese[num]);//将字符添加到缓冲区的末端
            }else{
                //这里是第一个数字，第一个数字前面没有计数单位，所以单独拿出处理
                zh.append(chinese[num]);
            }
        }
        //结果就是一千二百三十四
        System.out.println(zh);
    }
    }

