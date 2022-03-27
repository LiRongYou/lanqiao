package 作业;

import java.util.*;

/**
     * 1.创建Map集合存储牌，并且大的键对应大的牌，小的键对应小的牌
     * 2.洗牌，洗的是索引（map集合中每一张牌对应的键）
     * 3.发牌，发的索引，并且岁这个索引进行排序
     * 4.看牌，根据发到的键去map集合中找出对应的值
     */
    public class 模拟斗地主 {
        public static void main(String[] args) {
            //创建一个TreeMap集合
            TreeMap<Integer,String> Pokers=new TreeMap<Integer, String>();
            String[] colors={"♥","♠","♦","♣"};
            String[] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A",};
            //创建一个ArrayList集合，用来存储没有一张牌对应的索引
            ArrayList<Integer> indexs=new ArrayList<Integer>();
            int index = 0;
            for(String color:colors){
                for(String number:numbers){
                    Pokers.put(index, color+number);
                    indexs.add(index);
                    index++;
                }
            }//存大王，小王
            Pokers.put(index, "大王");
            indexs.add(index);
            index++;
            Pokers.put(index, "小王");
            indexs.add(index);
            index++;
            //洗牌，洗的是索引（map集合中每一张牌对应的键）
            Collections.shuffle(indexs);//对指定 List 集合进行随机排序。
            //发牌，发的是索引根据索引来找它对应的值
            TreeSet<Integer> zhangsan=new TreeSet<Integer>();
            TreeSet<Integer> lisi=new TreeSet<Integer>();
            TreeSet<Integer> wangma=new TreeSet<Integer>();
            TreeSet<Integer> dipai=new  TreeSet<Integer>();
            for(int i=0;i<Pokers.size();i++){
                if(i>=Pokers.size()-3){//最后三张为底牌
                    dipai.add(indexs.get(i));
                }else if(i%3==0){
                    zhangsan.add(indexs.get(i));
                }else if(i%3==1){
                    lisi.add(indexs.get(i));
                }else if(i%3==2){
                    wangma.add(indexs.get(i));
                }
            }//看牌
            lookPoker("张三",zhangsan,Pokers);
            lookPoker("李四",lisi,Pokers);
            lookPoker("王麻",wangma,Pokers);
            lookPoker("底牌",dipai,Pokers);
        }
        private static void lookPoker(String name, TreeSet<Integer> indexs,
                                      TreeMap<Integer, String> Pokers) {
            System.out.println(name+"的牌是：");
            List list = new ArrayList();
            for(Integer index:indexs){
                list.add(Pokers.get(index));
            }System.out.println(list);
        }
    }

