package test;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 抽奖
 *
 * @author Shadowalker
 */
public class Lottery {
    static String[] list = {};

    // 获奖人数
    static int max = 3;

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (; ; ) {
            if (set.size() == max) {
                break;
            }
            int random = new SecureRandom().nextInt(list.length);
            set.add(list[random]);
        }
        Iterator<String> iterator = set.iterator();
        System.out.println("-----抽奖-----");
        System.out.println("开奖人：Shadowalker");
        System.out.println("中奖名单:");
        while (iterator.hasNext()) {
            System.out.printf("中奖人：%s\r\n", iterator.next());
        }
        System.out.println("恭喜中奖的小朋友，请和我联系~");
    }
}
