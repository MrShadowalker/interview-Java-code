package designPattern.Adapter.proxy;

/**
 * 在对象适配器模式中，Adapter 角色通过委托来使用 Adaptee 角色。
 *
 * @author Shadowalker
 */
public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
