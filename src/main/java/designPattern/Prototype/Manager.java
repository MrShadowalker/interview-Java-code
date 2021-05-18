package designPattern.Prototype;

import java.util.HashMap;

/**
 * @author Shadowalker
 */
public class Manager {

    private HashMap showCase = new HashMap();

    public void register(String name, Product proto) {
        showCase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = (Product) showCase.get(protoname);
        return p.createClone();
    }

}
