package test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shadowalker
 */
public class MenuRecursion {

    /**
     * 子节点
     */
    static List<Menu> childMenu = new ArrayList<>();

    /**
     * 获取某个父节点下面的所有子节点
     *
     * @param menuList
     * @param father
     * @return
     */
    public static List<Menu> treeMenuList(List<Menu> menuList, Menu father) {
        for (Menu node : menuList) {
            if (node.getFather().equals(father.getId())) {
                treeMenuList(menuList, node);
                childMenu.add(node);
            }
        }
        return childMenu;
    }

    /**
     * 删除父节点及其所有子节点
     *
     * @param menuList
     * @param father
     */
    public static void deleteTreeMenuList(List<Menu> menuList, Menu father) {
        childMenu = treeMenuList(menuList, father);
        menuList.remove(father);
        for (Menu child : childMenu) {
            menuList.remove(child);
        }
    }

    public static void main(String args[]) {
        List<Menu> menuList = new ArrayList<>();
        Menu mu = new Menu();
        mu.setId("1");
        mu.setName("目录");
        mu.setFather("0");
        Menu mu1 = new Menu();
        mu1.setId("2");
        mu1.setName("目录1");
        mu1.setFather("1");
        Menu mu2 = new Menu();
        mu2.setId("3");
        mu2.setName("目录1.1");
        mu2.setFather("2");
        Menu mu3 = new Menu();
        mu3.setId("4");
        mu3.setName("目录1.2");
        mu3.setFather("2");
        Menu mu4 = new Menu();
        mu4.setId("5");
        mu4.setName("目录2");
        mu4.setFather("1");
        Menu mu5 = new Menu();
        mu5.setId("6");
        mu5.setName("目录2.1");
        mu5.setFather("5");
        Menu mu6 = new Menu();
        mu6.setId("7");
        mu6.setName("目录2.2");
        mu6.setFather("5");
        Menu mu7 = new Menu();
        mu7.setId("8");
        mu7.setName("目录2.2.1");
        mu7.setFather("7");
        menuList.add(mu);
        menuList.add(mu1);
        menuList.add(mu2);
        menuList.add(mu3);
        menuList.add(mu4);
        menuList.add(mu5);
        menuList.add(mu6);
        menuList.add(mu7);

        System.out.println(menuList);

        System.out.println("----------");

        List<Menu> childList = treeMenuList(menuList, mu1);
        for (Menu m : childList) {
            System.out.println(m.getId() + "   " + m.getName());
        }

        deleteTreeMenuList(menuList, mu1);
        System.out.println(menuList);
    }
}

@Data
class Menu {
    private String id;
    private String name;

    /**
     * 父节点
     */
    private String father;
}
