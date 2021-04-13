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
        // byte[] bytes = new byte[1000];
        // System.out.println(ClassLayout.parseInstance(bytes).toPrintable());
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
