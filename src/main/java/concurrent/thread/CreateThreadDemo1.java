package concurrent.thread;

/**
 * 继承 Thread 类，作为线程对象存在
 *
 * @author Shadowalker
 */
public class CreateThreadDemo1 extends Thread {

    /**
     * 构造方法，继承父类方法的 Thread(String name) 方法
     *
     * @param name
     */
    public CreateThreadDemo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName() + "线程执行了……");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CreateThreadDemo1 d1 = new CreateThreadDemo1("first");
        CreateThreadDemo1 d2 = new CreateThreadDemo1("second");

        d1.start();
        d2.start();

        // 中断第一个线程
        d1.interrupt();

        /**
         * 让线程等待的方法
         *
         * Thread.sleep(200); 让线程休息 2ms
         * Object.wait(); 让线程进入等待，直到调用 Object 的 notify() 或 notifyAll() 时，线程终止休眠
         */
    }
}
