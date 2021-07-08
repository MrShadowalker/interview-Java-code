package algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 分析，其实这道题和 JumpFrog1Demo 一样的，只是本来每次跳有两种选择，现在有n中选择，即f(n) = f(n-1) + f(n - 2) + f(n-3)+.....+f(1);
 *
 * @author Shadowalker
 */
public class JumpFrog2Demo {

    static Map<Integer, Integer> nMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("jump1: " + jump1(4));
        System.out.println("-------------------");
        // System.out.println("jump2: " + jump2(4));

    }

    private static int jump1(int n) {
        if (n <= 0) {
            nMap.put(n, 0);
            return 0;
        } else if (n == 1 || n == 2) {
            nMap.put(n, n);
            return n;
        } else {
            if (nMap.containsKey(n)) {
                return nMap.get(n);
            }
            int sum = 1;
            for (int i = n - 1; i > 0; i--) {
                sum += jump1(n - i);
            }
            nMap.put(n, sum);
            return sum;
        }
    }

    private static int jump2(int n) {

        return n;
    }
}
