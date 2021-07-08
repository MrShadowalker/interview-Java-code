package test;

// 评测题目: 基于擅长的语言实现一套LRU缓存,
// LRU是Least Recently Used的缩写，即最近最少使用，是一种常用的页面置换算法，
// 选择最久未使用的页面予以淘汰。

import java.util.HashMap;
import java.util.Map;

public class LRUDemo {


    class Node {
        int key;
        int value;
        Node prev;
        Node next;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }


    // 容量
    private int capacity;
    // 当前大小
    private int size;

    private Node head;
    private Node tail;

    // 哈希表存储
    private Map<Integer, Node> cache = new HashMap<>();

    // 容量大小，初始化
    LRUDemo(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    // get方法
    public int get(int key) {

        // 非空,如果不存在的话，就返回 k（不存在的意思）;
        Node node = cache.get(key);
        if (null == node) {
            return -1;
        }

        // 如果存在的话，把它放到头部，并且返回它
        move2Head(node);
        return node.value;
    }


    // put方法
    public void put(int key, int value) {

        // 判断是否已经存在
        Node node = cache.get(key);

        if (null == node) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            // 直接创建新的 Node，并且放到头部，或者 在头部创建同一个节点
            createHead(node);
            ++size;
            // 判断是否已满
            if (size > capacity) {
                // 如果已满，删除cache中的数据 ，并删掉尾部
                cache.remove(tail.key);
                Node tail = removeTail();
                --size;
            }
        }

        // 存在的话，更新 key 的 value，并且把它放到头部
        node.value = value;
        move2Head(node);

    }

    private void createHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 将节点移到头部
    private void move2Head(Node node) {

        // 方案一：重新建立连接

        // 方案二：删除节点，在头部创建同一个节点
        removeNode(node);
        createHead(node);
    }

    private Node removeTail() {

        Node newTailNode = tail.prev;
        removeNode(tail);
        return newTailNode;
    }

    // 删除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
