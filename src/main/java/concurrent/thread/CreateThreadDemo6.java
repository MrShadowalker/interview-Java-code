package concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Shadowalker
 */
public class CreateThreadDemo6 {

    public static void main(String[] args) {

        // 创建一个具有 10 个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        long threadpoolUseTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                /**
                 * When an object implementing interface <code>Runnable</code> is used
                 * to create a thread, starting the thread causes the object's
                 * <code>run</code> method to be called in that separately executing
                 * thread.
                 * <p>
                 * The general contract of the method <code>run</code> is that it may
                 * take any action whatsoever.
                 *
                 * @see Thread#run()
                 */
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程执行了……");
                }
            });
        }

        long threadpoolUseTimeEnd = System.currentTimeMillis();
        System.out.println("多线程用时：" + (threadpoolUseTimeEnd - threadpoolUseTimeStart));

        // 销毁线程池
        threadPool.shutdown();
        threadpoolUseTimeStart = System.currentTimeMillis();
    }
}
