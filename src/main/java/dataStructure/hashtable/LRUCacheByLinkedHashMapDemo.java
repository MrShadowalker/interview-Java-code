package dataStructure.hashtable;

/**
 * Leetcode 146
 * <p>
 * LRU 缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * <p>
 * 实现 LRUCacheByLinkedHashMapDemo 类：
 * <p>
 * LRUCacheByLinkedHashMapDemo(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * <p>
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * <p>
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * <p>
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现本题的两种操作，需要用到一个哈希表和一个双向链表。
 * 在面试中，面试官一般会期望读者能够自己实现一个简单的双向链表，而不是使用语言自带的、封装好的数据结构。
 * 在 Python 语言中，有一种结合了哈希表与双向链表的数据结构 OrderedDict，只需要短短的几行代码就可以完成本题。
 * 在 Java 语言中，同样有类似的数据结构 LinkedHashMap。
 * 这些做法都不会符合面试官的要求，因此下面只给出使用封装好的数据结构实现的代码，而不多做任何阐述。
 */
public class LRUCacheByLinkedHashMapDemo extends LinkedHashMap<Integer, Integer> {
    /**
     * Your LRUCacheByLinkedHashMapDemo object will be instantiated and called as such:
     * LRUCacheByLinkedHashMapDemo obj = new LRUCacheByLinkedHashMapDemo(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    private int capacity;

    public LRUCacheByLinkedHashMapDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
