package 作业;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现生产者和消费者线程协作
 * 定义一个集合模拟长条容器存放热狗，集合里实际存放 Integer 对象，其数值代表热狗的编号（热狗编号规则举例：300002 代表编号为 3 的厨师做的第 2 个热狗），这样能通过集合添加和删除操作实现长条容器内热狗的先进先出。
 * 以热狗集合作为对象锁，所有对热狗集合的操作（在长条容器中添加或取走热狗）互斥，这样保证不会出现多个顾客同时取最后剩下的一个热狗的情况，也不会出现多个厨师同时添加热狗造成长条容器里热狗数大于 10 个的情况。
 * 当厨师希望往长条容器中添加热狗时，如果发现长条容器中已有 10 个热狗，则停止做热狗，等待顾客从长条容器中取走热狗的事件发生，以唤醒厨师可以重新进行判断，是否需要做热狗。
 * 当顾客希望从长条容器中取走热狗时，如果发现长条容器中已没有热狗，则停止吃热狗，等待厨师往长条容器中添加热狗的事件发生，以唤醒顾客可以重新进行判断，是否可以取走热狗吃。
 */
public class 生产者和消费者线程协作 {
    //定义一个存放热狗的集合，里面存放的是整数，代表热狗编号
    private static final List<Integer> hotDogs = new ArrayList<Integer>();

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            new Producer(i).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Consumer(i).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    //生产者线程，以热狗集合作为对象锁，所有对热狗集合的操作互斥
    private static class Producer extends Thread {
        int i = 1;
        int pid = -1;

        public Producer(int id) {
            this.pid = id;
        }

        public void run() {
            while (true) {
                try {
                    //模拟消耗的时间
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (hotDogs) {
                    if (hotDogs.size() < 10) {
                        //热狗编号，如300002代表编号为3的生产者生产的第2个热狗
                        hotDogs.add(pid * 10000 + i);
                        System.out.println("生产者" + pid + "生产热狗，编号为：" + pid * 10000 + i);
                        i++;
                        //唤醒hotDogs对象锁上所有调用wait()方法的线程
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("热狗数已到10个，等待消费！");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //消费者线程，以热狗集合作为对象锁，所有对热狗集合的操作互斥
    private static class Consumer extends Thread {
        int cid = -1;

        public Consumer(int id) {
            this.cid = id;
        }

        public void run() {
            while (true) {
                synchronized (hotDogs) {
                    try {
                        //模拟消耗的时间
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (hotDogs.size() > 0) {
                        System.out.println("消费者" + this.cid + "正在消费一个热狗，其编号为： " + hotDogs.remove(0));
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("已没有热狗，等待生产！");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

