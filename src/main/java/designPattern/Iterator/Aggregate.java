package designPattern.Iterator;

/**
 * 角色：Aggregate，集合
 * 该角色负责定义创建 Iterator 角色的接口。
 * <p>
 * 表示集合的接口
 * 实现了该接口的类将成为一个可以保存多个元素的集合，就像数组一样。
 *
 * @author Shadowalker
 */
public interface Aggregate {

    /**
     * 生成一个用于遍历集合的迭代器
     *
     * @return
     */
    public abstract Iterator iteretor();
}
