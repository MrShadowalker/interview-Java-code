package dataStructure.queue;

/**
 * Leetcode 641
 * <p>
 * 设计循环双端队列
 * <p>
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * <p>
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * <p>
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * <p>
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * <p>
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * <p>
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * <p>
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * <p>
 * isEmpty()：检查双端队列是否为空。
 * <p>
 * isFull()：检查双端队列是否满了。
 * <p>
 * 提示：
 * <p>
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class MyCircularDequeDemo {

    /**
     * 链表实现
     */
    private int capacity;
    private int size;
    private Node front;
    private Node last;

    static class Node {

        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyCircularDequeDemo circularDeque = new MyCircularDequeDemo(4); // 设置容量大小为3
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
        // System.out.println(circularDeque.insertLast(1));             // 返回 true
        // System.out.println(circularDeque.insertLast(2));             // 返回 true
        // System.out.println(circularDeque.insertFront(3));            // 返回 true
        // System.out.println(circularDeque.insertFront(4));            // 已经满了，返回 false
        // System.out.println(circularDeque.getRear());                       // 返回 2
        // System.out.println(circularDeque.isFull());                        // 返回 true
        // System.out.println(circularDeque.deleteLast());                    // 返回 true
        // System.out.println(circularDeque.insertFront(4));            // 返回 true
        // System.out.println(circularDeque.getFront());                      // 返回 4
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDequeDemo(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        newNode.next = front;
        if (front != null) {
            front.prev = newNode;
        }
        front = newNode;
        if (last == null) {
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (front == null) {
            front = newNode;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node next = front.next;
        if (next != null) {
            next.prev = null;
            front.next = null;
        } else {
            last = null;
        }
        front = next;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node prev = last.prev;
        if (prev != null) {
            prev.next = null;
            last.prev = null;
        } else {
            front = null;
        }
        last = prev;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return front == null ? -1 : front.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return last == null ? -1 : last.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("This deque is empty");
            return sb.toString();
        }
        Node p = front;
        for (int i = 0; i < size; i ++) {
            sb.append("[").append(p.value).append("]");
            p = p.next;
        }
        sb.append(", first == ").append(getFront())
                .append(", last == ").append(getRear())
                .append(", size == ").append(size);
        return sb.toString();
    }

}