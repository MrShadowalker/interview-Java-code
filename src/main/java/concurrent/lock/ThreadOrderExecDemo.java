package concurrent.lock;

/**
 * 多个线程保证顺序执行
 *
 * @author Shadowalker
 */
@SuppressWarnings({"AlibabaAvoidManuallyCreateThread", "AlibabaCommentsMustBeJavadocFormat"})
public class ThreadOrderExecDemo {

    // 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
    // 在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，另外一个线程完成该线程继续执行。
    // 为了确保三个线程的顺序你应该先启动最后一个(T3调用T2， T2调用T1)，这样T1就会先完成而T3最后完成。

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t2线程，等待t2线程执行完
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        // 这里三个线程的启动顺序可以任意，实际上先启动三个线程中哪一个都行，因为在每个线程的 run 方法中用 join 方法限定了三个线程的执行顺序。
        t3.start();
        t2.start();
        t1.start();
    }
}
