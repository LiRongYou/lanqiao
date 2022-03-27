package 作业.多线程下的售票系统;

    public class SellTicketsMethod{//对象锁
        public static void main(String[] args){
            // 启动 4 个售票窗口
            // 程序代码
            SellThread t1 = new SellThread();
            SellThread t2 = new SellThread();
            SellThread t3 = new SellThread();
            SellThread t4 = new SellThread();

            new Thread(t1,"售票窗口1").start();// 模拟四个售票窗口同时售票
            new Thread(t2,"售票窗口2").start();
            new Thread(t3,"售票窗口3").start();
            new Thread(t4,"售票窗口4").start();

        }
    }
    // 创建子线程类 SellThread
    class SellThread implements Runnable{
        //这个票让四个线程共享
        static int piao=100;
        //确保这个锁对象，只有一个，多个线程公用一把锁
        static Object obj=new Object();
        int i=1;
        @Override
        public void run() {
            while (true) {
                if (i%4==0){
                    synchronized (this){
                        //当th1这个线程进来同步代码块后，就持有了这个锁，其他线程没有持有锁，那么就要处于等待状态，等在同步代码块的外面
                        if (piao >0) {
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "正在出售第：" + (piao--) + " 张票");
                        }
                    }
                }else{
                    maipiao();
                }
                i++;
            }
        }
        //同步方法：我们可以把一个方法用synchronized这个关键字修饰，来封装一段代码，来解决线程安全问题
        //同步方法：默认用的锁对象是this
        private synchronized void maipiao() {
            //System.out.println(this);
            if (piao >0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第：" + (piao--) + " 张票");
            }

        }
    }
