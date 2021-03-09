package designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

/**
 * 单例模式_静态内部类
 * 1. 本质上是利用类的加载机制来保证线程安全
 * 2. 只有在实际使用的时候，才会触发类的初始化，所以也是懒加载的一种形式。
 *
 *
 * @author Shadowalker
 */
class InnerClassSingleton {

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton() {
        // 防止通过反射的方式多实例化
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

}

public class InnerClassSingletonDemo {
    public static void main(String[] args) {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println("==============以下为多线程===============");
        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        }, "Thread1").start();
        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        }, "Thread2").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===============以下为反射================");
        try {
            Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(innerClassSingleton == instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
