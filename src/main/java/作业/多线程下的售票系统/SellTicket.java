package 作业.多线程下的售票系统;


public class SellTicket {
    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        new Thread(t1,"售票窗口1").start();// 模拟四个售票窗口同时售票
        new Thread(t2,"售票窗口2").start();
        new Thread(t3,"售票窗口3").start();
        new Thread(t4,"售票窗口4").start();
    }
}

class Ticket implements Runnable {
    static int ticket = 100;

    @Override
    public void run() {
        synchronized (this) {//线程同步  避免多线程发生冲突   代码同步块锁

            while (true) {
                // TODO Auto-generated method stub
                if (ticket <= 0) {
                    break;
                }
                ticket--;
                System.out.println(Thread.currentThread().getName() +  " 票号: " + ticket );
            }
        }
    }
}
