package designPattern.Singleton.multiThread;

/**
 * 单例模式_懒汉模式（懒加载）
 * 延迟加载，只有在真正使用的时候，才开始实例化
 * 问题：
 * 1. 线程安全问题
 * 2. double check lock DLC 加锁优化
 * 3. 编译器（JIT），CPU 可能进行指令重排，导致使用到尚未初始化的实例，可以通过 volatileTest 关键字进行修饰。
 *
 * @author Shadowalker
 */
class LazySingleton {

    /**
     * 线程安全问题通过 synchronized 解决
     */
    private static volatile LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {
                if (null == instance) {
                    instance = new LazySingleton();
                    // 字节码层
                    // JIT，CPU 重排序
                    // 1. 分配空间
                    // 2. 初始化
                    // 3. 引用赋值
                }
            }
        }
        return instance;
    }
}

/**
 * @author Shadowalker
 */
public class LazySingletonDemo {

    public static void main(String[] args) {

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }, "Thread1").start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }, "Thread2").start();
    }

}
