package 作业.线程的插队运行;

public class EmergencyThread implements Runnable {
    @Override
    public void run() {
            for (int i = 0; i <= 5; i++) {
                System.out.println("紧急情况：" + i+" 号车出发!");
            }
    }
}

