package jvm.jmm;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL
 * <p>
 * 全称为 Java Object Layout，是用来分析 JVM 中对象布局的工具，它可以帮我们在运行时计算某个对象的大小。
 *
 * @author Shadowalker
 */
public class JOLDemo {
    public static void main(String[] args) {

        // 如果先睡 5 秒，会发现 new Object() 创建的对象又变了，其实是涉及到一个锁升级的原因。
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        Object o = new Object();
        System.out.println("初始化新对象：" + ClassLayout.parseInstance(o).toPrintable());

        // 上锁
        synchronized (o) {
            // System.out.println("Hello, JOL!");
            // 不睡五秒，轻量级锁 00，也叫自旋锁
            // 睡五秒，偏向锁 101，偏向锁启动默认四秒
            System.out.println("对象加锁：" + ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println("对象解锁：" + ClassLayout.parseInstance(o).toPrintable());
    }
}
