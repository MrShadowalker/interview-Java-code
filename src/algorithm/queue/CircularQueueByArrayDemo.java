package algorithm.queue;

import lombok.Data;

/**
 * 循环队列
 * <p>
 * 数组实现
 *
 * @author Shadowalker
 */
@Data
public class CircularQueueByArrayDemo {

    private int[] queue;
    private int size;
    private int head, tail;

    public static void main(String[] args) {
        CircularQueueByArrayDemo arrayQueue = new CircularQueueByArrayDemo(5);
        int[] queue = {1, 3, 5};
        arrayQueue.setQueue(queue);
        System.out.println(arrayQueue);
        arrayQueue.enQueue(4);
        System.out.println(arrayQueue);
        arrayQueue.deQueue();
        System.out.println(arrayQueue);

    }

    public CircularQueueByArrayDemo(int k) {
        this.queue = new int[k];
        this.size = k;
    }

    // 向队尾添加值
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
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
