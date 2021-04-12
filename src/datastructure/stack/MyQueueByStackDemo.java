package datastructure.stack;

import java.util.Stack;

/**
 * Leetcode 232
 * <p>
 * 用栈实现队列
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *  
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class MyQueueByStackDemo {

    public static void main(String[] args) {
        MyQueueByStackDemo obj = new MyQueueByStackDemo();
        System.out.println(obj.empty()); // return true
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.empty()); // return false
        System.out.println(obj.outStack); // return [3, 2, 1]
        System.out.println(obj.inStack); // return [3, 2, 1]
        int param_2 = obj.pop(); // return 1
        System.out.println(obj.outStack); // return [3, 2]
        int param_3 = obj.peek(); // return 2
        System.out.println(obj.outStack); // return [3, 2]
        boolean param_4 = obj.empty(); // return false
        System.out.println(param_2 + " " + param_3 + " " + param_4);
    }

    // inStack 存放入队列
    // outStack 存放出队列
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueueByStackDemo() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     *
     * @param x
     */
    /**
     * in:1,2
     * out:2
     * tmp:1,2
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.empty()) {
            in2out();
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.empty()) {
            in2out();
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void in2out() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
    }

}
