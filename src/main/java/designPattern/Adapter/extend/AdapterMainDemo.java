package designPattern.Adapter.extend;

/**
 * 角色：Client，请求者
 * 该角色负责使用 Target 角色所定义的方法进行具体处理。
 *
 * @author Shadowalker
 */
public class AdapterMainDemo {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
