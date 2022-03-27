package 作业.线程的插队运行;

public class JoinThread {
    public static void main(String[] args) {
        Thread t = new Thread(new EmergencyThread());
        t.start();
        for (int i = 0; i <= 5; i++) {
            if (true) {
                try {
                    t.join(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("正常情况：" + i + " 号车出发");
        }
    }
}
