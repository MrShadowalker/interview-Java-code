package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 和 Lock 有什么区别？用新的 Lock 有什么好处？
 *
 * 1. 原始构成
 * synchronized 属于 JVM 层面，是 Java 关键字；
 *     monitorenter（底层是通过 monitor 对象来完成，其实 wait/notify 等方法也依赖于 monitor 对象。只有在同步块或方法中才能调 wait/notify 等方法。）
 *     monitorexit
 * Lock 属于 API 层面的锁，java.util.concurrent.locks.Lock。
 *
 * 2. 使用方法
 * synchronized 不需要用户去手动释放锁，当 synchronized 代码执行完后系统会自动让线程释放对锁的占用。即使发生异常等场景，也会自动释放。不会产生死锁。
 * ReentrantLock 则需要用户去手动释放锁，若没有主动释放锁，就有可能导致出现死锁现象。
 *
 * 3. 等待是否可中断
 * synchronized 不可中断，除非抛出异常或者正常运行完成。
 * ReentrantLock 可中断，1）设置超时方法 tryLock(long timeout, TimeUnit unit)
 *                      2) lockInterruptibly() 放代码块中，调用 interrupt() 方法可中断
 *
 * 4. 加锁是否公平
 * synchronized 非公平锁。
 * ReentrantLock 默认公平锁，构造方法可传入 boolean 值，true 为公平锁，false 为非公平锁。
 *
 * 5. 锁绑定多个条件 Condition
 * synchronized 没有
 * ReentrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像 synchronized 要么随机唤醒一个线程 notify() 要么唤醒全部线程 notifyAll()。
 * =====================================================================================================================
 * 题目：
 * 多线程之间按顺序调用，实现 A->B->C 三个线程启动，要求如下：
 * A 打印 5 次，B 打印 10 次，C 打印 15 次
 * 紧接着
 * A 打印 5 次，B 打印 10 次，C 打印 15 次
 * 共循环 10 次
 *
 * @author Shadowalker
 */
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}

class ShareResource {

    // A:1,B:2,C:3
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    // 多线程方法：
    // 1 判断
    // 2 干活
    // 3 通知

    public void print5() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                condition1.await();
            }
            // 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 通知
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                condition2.await();
            }
            // 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 通知
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                condition3.await();
            }
            // 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 通知
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
