package concurrent.thread;

/**
 * 实现 Runnable 接口，作为线程任务存在
 * <p>
 * Runnable 只是来修饰线程锁执行的任务，它不是一个线程对象。想要启动 Runnable 对象，必须将它放到一个线程对象里。
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class CreateThreadDemo2 implements Runnable {
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
        while (true) {
            System.out.println("线程执行了……");
        }
    }

    public static void main(String[] args) {
        // 将线程任务传给线程对象
        Thread thread = new Thread(new CreateThreadDemo2());
        // 启动线程
        thread.start();
    }
}
