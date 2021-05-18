package designPattern.Iterator;


/**
 * 角色：ConcreteIterator，具体的迭代器
 * 该角色负责实现 Iterator 角色所定义的接口，其中包含了遍历集合所必需的信息。
 * 遍历书架的类
 *
 * @author Shadowalker
 */
public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
