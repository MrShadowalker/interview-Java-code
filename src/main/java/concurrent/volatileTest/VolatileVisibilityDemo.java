package concurrent.volatileTest;

/**
 * volatile 保证 可见性
 *
 * @author Shadowalker
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class VolatileVisibilityDemo {

    // private static boolean initFlag = false;

    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data ...");
            while (!initFlag) {
            }
            System.out.println("================success");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> prepareData()).start();
    }

    private static void prepareData() {
        System.out.println("prepare================");
        initFlag = true;
        System.out.println("prepare data end.");
    }
}
