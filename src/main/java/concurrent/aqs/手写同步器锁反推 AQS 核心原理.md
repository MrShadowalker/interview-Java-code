# 并发存在的问题

多线程编程中，有可能会出现多个线程同时访问同一个**共享、可变**资源的情况；

这种资源可能是：对象、变量、文件等。

- **共享**：资源可以由多个线程同时访问；
- **可变**：资源可以在其生命周期内被修改。

存在的问题：
由于线程执行的过程是不可控的，所以需要采用同步机制来协同对对象可变状态的访问。

例如秒杀场景，单核时，也很可能发生超卖。

synchronized, juc, ReentrantLock

只能用纯 Java 自己手写同步器，实现一个公平同步器——公平锁。

手写 AQS，公共资源，所有线程并发来抢，但只有一个能抢到。

资源获取操作必须得是原子的，不可中断。CAS