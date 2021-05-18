package dataStructure.queue;

import lombok.Data;

/**
 * Leetcode 622
 * <p>
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
        int[] queue = new int[5];
        arrayQueue.setQueue(queue);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(5);

        System.out.println(arrayQueue);
        arrayQueue.enQueue(4);
        System.out.println(arrayQueue);
        arrayQueue.deQueue();
        System.out.println(arrayQueue);

    }

    public CircularQueueByArrayDemo(int k) {
        this.queue = new int[k];
        this.size = k;
        this.head = -1;
        this.tail = -1;
    }

    // 向队尾添加值
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        queue[tail] = value;
        return true;
    }

    // 从队首删除值
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[tail];
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
