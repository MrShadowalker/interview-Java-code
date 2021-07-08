package concurrent.thread;

/**
 * 停止一个正在运行的线程
 *
 * @author Shadowalker
 */
public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread m1 = new MyThread();
        System.out.println("Starting thread ...");
        // start()方法和run()方法的区别
        // 只有调用了start()方法，才会表现出多线程的特性，不同线程的run()方法里面的代码交替执行。
        // 如果只是调用run()方法，那么代码还是同步执行的，必须等待一个线程的run()方法里面的代码全部执行完毕之后，另外一个线程才可以执行其run()方法里面的代码。
        m1.start();
        // sleep方法和wait方法有什么区别
        // 对于sleep()方法，我们首先要知道该方法是属于Thread类中的。而wait()方法，则是属于Object类中的。
        // sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
        // 在调用sleep()方法的过程中，线程不会释放对象锁。
        // 当调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备，获取对象锁进入运行状态。
        Thread.sleep(1000);
        System.out.println("Interrupt thread ...: " + m1.getName());
        // 设置共享变量为 true
        m1.stop = true;
        // 阻塞时退出阻塞状态
        m1.interrupt();
        // 主线程休眠 3 秒以便观察线程 m1 的中断情况
        Thread.sleep(3000);
        System.out.println("Stopping application ...");
    }
}

class MyThread extends Thread {
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println(getName() + " is running ...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("week up from blocking ...");
                // 在异常处理代码中修改共享变量的状态
                stop = true;
            }
        }
        System.out.println("Stopping application ...");
    }
}