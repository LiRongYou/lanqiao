package 作业;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class 获取百度首页信息{
    //资源获取
    public void infos(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要定位的URL地址：");
        String url = input.next();
        // System.out.print("请输入要显示哪个页面标签元素的内容：");
        // String iStr = input.next();
        BufferedReader in = null;
        try {
            // 通过 url 字符串创建 URL 对象
            URL tURL = new URL(url);
            // 通过 IO 流读取信息
            in = new BufferedReader(new InputStreamReader(tURL.openStream()));
            String s;
            while((s = in.readLine()) != null){
                // 匹配指定的标签内容
                // if(s.contains(iStr)){
                System.out.println(s);
                // }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            // 资源释放
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            input.close();
        }
    }
    public static void main(String[] args){
        new 获取百度首页信息().infos();
    }
}

