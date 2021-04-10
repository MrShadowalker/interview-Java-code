package algorithm.queue;

/**
 * 循环队列
 * <p>
 * 数组实现
 *
 * @author Shadowalker
 */
public class CircularQueueByArrayDemo {

    private int[] queue;
    private int size;
    private int head, tail;

    public static void main(String[] args) {

    }

    public CircularQueueByArrayDemo(int k) {
        this.queue = new int[k];
        this.size = k;
        this.head = 0;
        this.tail = 0;
    }

    // 向队尾添加值
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        return true;
    }

    // 从队首删除值
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        return true;
    }

    public int Front() {
        return this.queue[head];
    }

    public int Rear() {
        return this.queue[tail];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == queue.length;
    }
}
