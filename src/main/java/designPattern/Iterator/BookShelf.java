package designPattern.Iterator;

/**
 * 角色：ConcreteAggregate，具体的集合
 * 该角色负责实现 Aggregate 角色所定义的接口，它会创建出具体的 Iterator 角色，即 ConcreteIterator 角色。
 * <p>
 * 表示书架的类
 * 由于需要将该类作为集合进行处理，所以事先 Aggregate 接口。
 *
 * @author Shadowalker
 */
public class BookShelf implements Aggregate {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iteretor() {
        return new BookShelfIterator(this);
    }
}
