# synchronized 和 Lock 有什么区别？用新的 Lock 有什么好处？

## 1. 原始构成

synchronized 属于 JVM 层面，是 Java 关键字； monitorenter（底层是通过 monitor 对象来完成，其实 wait/notify 等方法也依赖于 monitor 对象。只有在同步块或方法中才能调
wait/notify 等方法。） monitorexit Lock 属于 API 层面的锁，java.util.concurrent.locks.Lock。

## 2. 使用方法

synchronized 不需要用户去手动释放锁，当 synchronized 代码执行完后系统会自动让线程释放对锁的占用。即使发生异常等场景，也会自动释放。不会产生死锁。 ReentrantLock
则需要用户去手动释放锁，若没有主动释放锁，就有可能导致出现死锁现象。

## 3. 等待是否可中断

synchronized 不可中断，除非抛出异常或者正常运行完成。 ReentrantLock 可中断，1）设置超时方法 tryLock(long timeout, TimeUnit unit)
2) lockInterruptibly() 放代码块中，调用 interrupt() 方法可中断

## 4. 加锁是否公平

synchronized 非公平锁。 ReentrantLock 默认公平锁，构造方法可传入 boolean 值，true 为公平锁，false 为非公平锁。

## 5. 锁绑定多个条件 Condition

synchronized 没有 ReentrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像 synchronized 要么随机唤醒一个线程 notify() 要么唤醒全部线程 notifyAll()。