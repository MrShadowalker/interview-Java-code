package concurrent.thread;

/**
 * 匿名内部类创建线程对象
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class CreateThreadDemo3 extends Thread {
    public static void main(String[] args) {

        // 创建无参线程对象
        new Thread() {
            @Override
            public void run() {
                System.out.println("无参线程对象-线程执行了……");
            }
        }.start();

        // 创建带线程任务的线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("带线程任务的线程对象-线程执行了……");
            }
        }).start();

        // 创建带线程任务并且重写 run 方法的线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable run 线程执行了……");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Override run 线程执行了……");
            }
        }.start();
    }
}
