package designPattern.Iterator;

/**
 * 遍历集合的接口
 * <p>
 * Iterator 模式
 * 迭代器模式
 * 将循环变量 i 的作用抽象化、通用化后形成的模式，称为迭代器模式。
 * Iterator 模式用于在数据集合中按照顺序遍历集合，
 * <p>
 * 适应设计模式
 * <p>
 * 一个一个遍历
 *
 * @author Shadowalker
 */
public interface Iterator {

    public abstract boolean hasNext();

    public abstract Object next();
}
