package designPattern.Prototype;

/**
 * @author Shadowalker
 */
public class ProtoMainDemo {

    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning message", mbox);
        manager.register("slash box", sbox);

        // 生成
        String string = "Hello, World!";
        Product p1 = manager.create("strong message");
        p1.use(string);
        Product p2 = manager.create("warning message");
        p2.use(string);
        Product p3 = manager.create("slash box");
        p3.use(string);
    }
}
