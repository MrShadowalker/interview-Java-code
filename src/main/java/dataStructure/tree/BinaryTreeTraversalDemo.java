package dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shadowalker
 */
public class BinaryTreeTraversalDemo {

    /**
     * 树节点
     */
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }

    /********** 先序遍历 **********/
    /**
     * 递归
     */
    public static void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 非递归
     */
    public static void preOrderByStack(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(root.right);
            }
            if (node.left != null) {
                stack.push(root.left);
            }
        }
    }

    /**
     * Morris 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //首先把根节点赋值给cur
        TreeNode cur = root;
        //如果cur不为空就继续遍历
        while (cur != null) {
            if (cur.left == null) {
                //如果当前节点cur的左子节点为空，就访问当前节点cur，
                //接着让当前节点cur指向他的右子节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                //查找pre节点，注意这里有个判断就是pre的右子节点不能等于cur
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                //如果pre节点的右指针指向空，我们就让他指向当前节点cur，
                //然后打印当前节点cur的值，最后再让当前节点cur指向他的左子节点
                if (pre.right == null) {
                    pre.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                } else {
                    //如果pre节点的右指针不为空，那么他肯定是指向cur的,
                    //表示当前节点cur和他的的左子节点都遍历完了，直接
                    //让他指向他的右子节点即可。
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /********** 中序遍历 **********/
    /**
     * 递归
     */
    public static void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 非递归
     */
    public static void inOrderByStack(TreeNode root) {

        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (null != root || !stack.empty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.empty()) {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    /********** 后序遍历 **********/
    /**
     * 递归
     */
    public static void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 非递归
     */
    public static void postOrderByStack1(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.empty()) {
            root = s1.pop();
            s2.push(root);
            if (null != root.left) {
                s1.push(root.left);
            }
            if (null != root.right) {
                s1.push(root.right);
            }
        }
        while (!s2.empty()) {
            System.out.println(s2.pop().val);
        }
    }

    /**
     * 非递归
     */
    public static void postOrderByStack2(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.empty()) {
            node = stack.peek();
            if (null != node.left && root != node.left && root != node.right) {
                stack.push(node.left);
            } else if (null != node.right && root != node.right) {
                stack.push(node.right);
            } else {
                System.out.println(stack.pop().val);
                root = node;
            }
        }
    }

    /********** 广度优先遍历 **********/
    public static void levelOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        // 链表，这里可以把它看成队列
        LinkedList<TreeNode> list = new LinkedList<>();
        // 相当于把数据加入到队列尾部
        list.add(root);
        while (!list.isEmpty()) {
            // poll 方法相当于移除队列头部的元素
            TreeNode node = list.poll();
            System.out.println(node.val);
            if (null != node.left) {
                list.add(node.left);
            }
            if (null != node.right) {
                list.add(node.right);
            }
        }
    }

    /**
     * 递归
     */
    public static void levelOrderByDg(TreeNode root) {
        int depth = depth(root);
        for (int level = 0; level < depth; level++) {
            printLevel(root, level);
        }
    }

    private static int depth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.min(left, right) + 1;
    }

    private static void printLevel(TreeNode root, int level) {
        if (null == root) {
            return;
        }
        if (level == 0) {
            System.out.println(" " + root.val);
        } else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    /**
     * 如果把遍历结果存放到 list 中，还可以这样写
     */
    public static List<List<Integer>> levelOrderByList(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, 0, list);
        return list;
    }

    private static void bfs(TreeNode root, int level, List<List<Integer>> list) {
        if (null == root) {
            return;
        }
        if (level >= list.size()) {
            List<Integer> subList = new ArrayList<>();
            subList.add(root.val);
            list.add(subList);
        } else {
            list.get(level).add(root.val);
        }
        bfs(root.left, level + 1, list);
        bfs(root.right, level + 1, list);
    }

    /********** 深度优先遍历 **********/
    /**
     * 递归
     */
    public static void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void dfsByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }
}


