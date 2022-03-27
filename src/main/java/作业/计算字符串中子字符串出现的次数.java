package 作业;

import java.util.Scanner;

public class 计算字符串中子字符串出现的次数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = input.next();
        System.out.println("请输入要查找的字符串：");
        String str1 = input.next();
        int temp=0;
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.indexOf(str1,temp)!=-1){
                temp=str.indexOf(str1,temp)+str1.length();
                count++;
            }
        }
        System.out.println(str1+" 在 "+str+" 出现的次数为 "+count);
    }
}
