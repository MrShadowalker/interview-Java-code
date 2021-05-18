package designPattern.Iterator;

/**
 * 角色：Iterator，迭代器
 * 该角色负责定义按顺序逐个遍历元素的接口。
 * 遍历集合的接口，其作用相当于循环语句中的循环变量。
 * <p>
 * Iterator 模式
 * 迭代器模式
 * 将循环变量 i 的作用抽象化、通用化后形成的模式，称为迭代器模式。
 * Iterator 模式用于在数据集合中按照顺序遍历集合。
 * <p>
 * 适应设计模式
 * <p>
 * 一个一个遍历
 *
 * @author Shadowalker
 */
public interface Iterator {

    /**
     * 判断是否存在下一个元素
     *
     * @return
     */
    public abstract boolean hasNext();

    /**
     * 返回当前的元素，并指向下一个元素
     *
     * @return
     */
    public abstract Object next();
}
