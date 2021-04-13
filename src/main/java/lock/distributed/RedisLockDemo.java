package lock.distributed;

public class RedisLockDemo {
    // V1 synchronized 单机版 OK，上分布式凉凉。
    // V2 Nginx（负载均衡 + 路由） 分布式微服务，单机锁不行。
    // V3 取消单机锁，上 Redis 分布式锁，setNx。
    // V4 加了锁，没有释放锁，出异常的话，可能无法释放锁，必须要在代码层面 finally 释放锁。
    // V5 宕机了，部署了微服务代码层面根本没有走到 finally 这块，没办法保证解锁，这个 key 没有被删除。需要有 lockKey 的过期时间设定。
    // V6 为 Redis 的分布式锁 key 增加过期时间，此外，还必须要 setNx 和 过期时间 必须同一行，保证原子操作。
    // V7 必须规定只能自己删除自己的锁，不能把别人的锁删掉。
    // V8 Redis 集群环境下，我们自己写的也不 OK。直接上 RedLock 之 Redisson 落地实现。
    // 为增加健壮性，建议 finally 中添加如下逻辑：
    // if (redissonLock.isLocked() && redissonLock.isHeldByCurrentThread()) {
    //     redissonLock.unlock();
    // }
}
