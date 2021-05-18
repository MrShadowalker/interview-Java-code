package designPattern.Singleton.msb;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM 保证线程安全
 * 简单实用，推荐使用
 * <p>
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * <p>
 * Class.forName("") 只加载类，但不实例化
 * <p>
 * 话说，你不用它，你装载它干嘛？
 *
 * @author Shadowalker
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    /**
     * 构造方法设置为 private，别人就调不了，只能通过 getInstance 使用
     */
    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
