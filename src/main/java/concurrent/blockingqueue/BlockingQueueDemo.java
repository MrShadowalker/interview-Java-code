package concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO 原则对元素进行排序。
 * LinkedBlockingQueue：是一个基于链表结构的有界（Integer.MAX_VALUE）阻塞队列，此队列按照 FIFO 原则排序元素，吞吐量通常要高于 ArrayBlockingQueue。
 * SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于 ArrayBlockingQueue 和 LinkedBlockingQueue。
 *
 * PriorityBlockingQueue：支持优先级排序的无界阻塞队列。
 * DelayQueue：使用优先级队列实现的延迟无界阻塞队列。
 * LinkedTransferQueue：由链表结构组成的无界阻塞队列。
 * LinkedBlockingDeque：由链表结构组成的双向阻塞队列。
 *
 * 1 阻塞队列
 * 当阻塞队列为空时，从队列中获取元素的操作会被阻塞；
 * 当阻塞队列为满时，向队列中添加元素的操作会被阻塞。
 * 生产者/消费者模式
 * eg：蛋糕店柜台
 * 1.1 阻塞队列有没有好的一面
 * 1.2 不得不阻塞，你如何管理
 *
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒。
 *
 * 为什么要 BlockingQueue
 * 好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切都被 BlockingQueue 一手包办了
 *
 * 在 Concurrent 包发布前，在多线程环境下，都需要程序员自己控制这些细节，尤其还要兼顾效率与线程安全，而这会给我们编程带来不小的复杂度。
 *
 * 2 阻塞队列核心方法
 * | 方法类型 | 抛出异常   | 特殊值    | 阻塞    | 超时                 |
 * | 插入    | add(e)    | offer(e) | put(e) | offer(e, time, unit) |
 * | 移除    | remove(e) | poll()   | take() | poll(time, unit)     |
 * | 检查    | element() | peek()   | 不可用  | 不可用                |
 *
 * 3 应用
 * 3.1 生产者/消费者模式
 * 3.1.1 传统模式 ProdConsumer_TraditionDemo
 * 3.2 线程池
 * 3.3 消息中间件
 *
 * @author Shadowalker
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");

    }
}
