package 作业.多线程下的售票系统;

public class Window implements Runnable {

    private String name;

    private static Object ob = new Object();

    public Window(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (Station.tickCount > 0) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (Station.tickCount > 0) {
                    System.out.println(name + " 票号： " + Station.tickCount);
                    Station.tickCount--;
                } else {
                    System.out.println("票卖完了");
                }
            }

            try {
                Thread.sleep(1000);//速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

