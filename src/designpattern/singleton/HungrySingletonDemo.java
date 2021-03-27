package designpattern.singleton;

/**
 * 单例模式_饿汉模式
 * 类加载的初始化阶段就完成了实例的初始化。
 * 本质上就是借助于 JVM 类加载机制，保证实例的唯一性。
 * <p>
 * 类加载过程：
 * 1. 加载二进制数据到内存中，生成对应的 Class 数据结构。
 * 2. 连接：
 * 2.1 验证 （Class 文件是否符合 JVM 规范）
 * 2.2 准备 （给类的静态成员变量赋默认值）
 * 2.3 解析
 * 3. 初始化：给类的静态变量赋初始值。
 * <p>
 * 只有在真正使用对应的类时，才会触发初始化。
 * eg：当前类是启动类，即 main 函数所在类，直接进行 new 操作，访问静态属性。访问静态方法，用反射访问类，初始化一个类的子类等。
 *
 * @author Shadowalker
 */
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}

/**
 * @author Shadowalker
 */
public class HungrySingletonDemo {
    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance2);

    }
}
