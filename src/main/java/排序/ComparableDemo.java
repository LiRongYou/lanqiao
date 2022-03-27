package 排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {
        Product p1=new Product();
        p1.setpName("铠侠LRC10Z500GC8");
        p1.setPrice(359.00f);
        p1.setpNo(100007080973L);
        p1.setWeight(40.00f);
        p1.setLocation("中国大陆");
        p1.setCapacity("480-512GB");
        p1.setInterfaces("M.2接口");

        Product p2=new Product();
        p2.setpName("金士顿A400系列");
        p2.setPrice(229.00f);
        p2.setpNo(4311178);
        p2.setWeight(70.00f);
        p2.setLocation("中国台湾");
        p2.setCapacity("240-256GB");
        p2.setInterfaces("SATA接口");

        Product p3=new Product();
        p3.setpName("三星980");
        p3.setPrice(839.00f);
        p3.setpNo(100018768506L);
        p3.setWeight(79.00f);
        p3.setLocation("韩国");
        p3.setCapacity("960GB-1TB");
        p3.setInterfaces("M.2接口");

        List<Product> list=new ArrayList<Product>();//规定集合只能添加Product类型的数据
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collections.sort(list,new CapacityComparator());
        /*
        Exception in thread "main" java.lang.ClassCastException: class Product cannot be cast to class java.lang.Comparable
         (Product is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
         商品不能进行排序
         */
        // 只打印商品的名称和价格？
        for(Product p:list){
            System.out.print(p.getpName());
            System.out.print("\t"+p.getPrice());
            System.out.println("\t"+p.getCapacity());
        }
        /*for(Object p:list){
            Product product=(Product) p;
            System.out.print(product.getpName());
            System.out.println("\t"+product.getPrice());
        }*/
    }
}
