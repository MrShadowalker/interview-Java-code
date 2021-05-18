package designPattern.Adapter.extend;

import lombok.Data;

/**
 * 角色：Adaptee，被适配
 * Adaptee 是一个持有既定方法的角色。
 * 如果 Adaptee 角色中的方法和 Target 角色的方法相同，则不需要接下来的 Adapter 角色了。
 *
 * @author Shadowalker
 */
@Data
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
