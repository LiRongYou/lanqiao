package 作业;

import java.util.ArrayList;
import java.util.Iterator;

public class 去掉重复的号码 {
    public static void main(String[] args) {
        ArrayList list= new ArrayList();
        Object a[]={"1231561","89571806","151235","76824338","89571806","121311","89571806","13211","76824338","123456","76824338","123456","89571806","12344","76824338","12344","76824338","112345","123456","1123344","7677471","89571806","1475639","76824338","89571806","1805385443","18117197","774768204","76824338","89571806","76824338","10172214","1345759","75776909","757747069"};
        for(int i=0;i<a.length;i++) {
            list.add(a[i]);
        }
        System.out.println(list);
        System.out.println(repeat(list));
    }
    public static ArrayList repeat (ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i).toString().equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
        return list;//有一个重复
//        ArrayList newList = new ArrayList();
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            Object obj = it.next();
//            if (!newList.contains(obj)) {
//                newList.add(obj);
//            }
//        }
//        return newList;
    }
}
