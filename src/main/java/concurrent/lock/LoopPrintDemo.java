package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C。
 * <p>
 * 每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
 * <p>
 * 如：ABCABCABC…… 依次递归
 * <p>
 * 线程本来是抢占式进行的，要按序交替，所以必须实现线程通信，那就要用到等待唤醒。
 * <p>
 * 可以使用同步方法，也可以用同步锁。
 *
 * @author Shadowalker
 */
public class LoopPrintDemo {
    public static void main(String[] args) {
        AlternationDemo ad = new AlternationDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopC();
                }
            }
        }, "C").start();
    }
}

class AlternationDemo {
    private int number = 1;//当前正在执行的线程的标记
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            if (number != 1) { //判断
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());//打印
            number = 2;
            condition2.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            if (number != 2) { //判断
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());//打印
            number = 3;
            condition3.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            if (number != 3) { //判断
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());//打印
            number = 1;
            condition1.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
