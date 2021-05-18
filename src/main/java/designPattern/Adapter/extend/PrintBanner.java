package designPattern.Adapter.extend;

/**
 * 角色：Adapter，适配
 * Adapter 模式的主人公。使用 Adaptee 角色的方法来满足 Target 角色的需求，这是 Adapter 模式的目的，也是 Adapter 角色的作用。
 * 在类适配器模式中，Adapter 通过继承来使用 Adaptee 角色。
 *
 * @author Shadowalker
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
