package designPattern.Factory;

import designPattern.Factory.framework.Factory;
import designPattern.Factory.framework.Product;
import designPattern.Factory.idcard.IDCardFactory;

/**
 * @author Shadowalker
 */
public class FactoryMainDemo {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("陈子豪");
        Product card2 = factory.create("金林");
        Product card3 = factory.create("牛慧升");
        card1.use();
        card2.use();
        card3.use();
    }
}
