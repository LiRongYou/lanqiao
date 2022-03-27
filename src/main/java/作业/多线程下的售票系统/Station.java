package 作业.多线程下的售票系统;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    public class Station {
        private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        public static int tickCount = 20;

        public static void main(String[] args) {
            for (int i = 1; i <= 4; i++) {
                Window station = new Window("售票窗口" + i);
                cachedThreadPool.execute(station);
            }
        }
    }
