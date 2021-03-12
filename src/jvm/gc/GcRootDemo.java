package jvm.gc;

/**
 * 在 Java 中，可作为 GC Root 的对象有：
 * 1. 虚拟机栈中引用变量
 * 2. 方法区中的类静态属性引用的对象
 * 3. 方法区中常量引用的对象
 * 4. 本地方法栈中 JNI 中引用的对象
 */
public class GcRootDemo {

    private byte[] byteArray = new byte[100 * 1024 * 1024];

    // private static GcRootDemo2 t2;

    // private static final GcRootDemo3 t3 = new GcRootDemo3(8);

    public static void m1() {
        GcRootDemo t1 = new GcRootDemo();
        System.gc();;
        System.out.println("第一次 GC 完成！");
    }

    public static void main(String[] args) {
        m1();
    }
}
