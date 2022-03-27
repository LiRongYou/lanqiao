package 作业;

import java.util.Scanner;

public class 用线程实现秒表倒计时 {
    public static void main(String[] args) {

        new 用线程实现秒表倒计时().go();
    }

    public void go() {
        System.out.println("**请输入倒计时秒数:**");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        ShowTime showTime = new ShowTime(i);
        Thread thread = new Thread(showTime);
        thread.start();

    }

    public class ShowTime implements Runnable {
        int i;

        public ShowTime(int i) {
            this.i = i;
        }

        public void run() {
            try {
                while (i > 0) {
                    i--;
                    Thread.sleep(1000);

                    System.out.println(i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

