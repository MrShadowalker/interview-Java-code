package designPattern.Adapter.proxy;

/**
 * @author Shadowalker
 */
public class AdapterMainDemo {

    public static void main(String[] args) {

        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
