package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 225
 * <p>
 * 用队列实现栈
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class MyStackByQueueDemo {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public static void main(String[] args) {
        MyStackByQueueDemo obj = new MyStackByQueueDemo();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        for (int i : obj.queue1) {
            System.out.println(i);
        }
        int param_1 = obj.pop();
        System.out.println("pop:" + param_1);
        int param_2 = obj.top();
        System.out.println("top:" + param_2);
        boolean param_3 = obj.empty();
        System.out.println("empty:" + param_3);
    }


    /**
     * Initialize your datastructure here.
     */
    public MyStackByQueueDemo() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("栈中无元素，不可 pop！");
        }
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("栈中无元素，不可 top！");
        }
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
