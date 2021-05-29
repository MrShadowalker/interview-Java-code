package concurrent.volatileTest;

/**
 * volatile 保证可见性与有序性，但不保证原子性
 *
 * @author Shadowalker
 */
@SuppressWarnings({"AlibabaAvoidManuallyCreateThread", "AlibabaUndefineMagicConstant"})
public class VolatileAtomicDemo {

    public static volatile int num = 0;

    public static void increase() {
        num++;
    }

    public static synchronized void syncIncrease() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();  // 10 * 1000 = 10000
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(num);
    }

}