package 作业;

import java.util.Iterator;
import java.util.TreeSet;

public class 使用Iterator显示数据信息 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int [] arry ={12,45,23,86,100,78,546,1,45,99,136,23};
        for (int i=0;i<arry.length;i++){
            set.add(arry[i]);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
