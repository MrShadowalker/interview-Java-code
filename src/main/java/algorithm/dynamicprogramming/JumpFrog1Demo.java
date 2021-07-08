package algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * @author Shadowalker
 */
public class JumpFrog1Demo {

    static Map<Integer, Integer> nMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("jump1: " + jump1(5));
        System.out.println("-------------------");
        System.out.println("jump2: " + jump2(5));
        System.out.println("-------------------");
        System.out.println("jump3: " + jump2(5));

    }

    public static int jump1(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        }
        return jump1(n - 1) + jump1(n - 2);
    }

    // 上面的 jump1 方法有很多重复计算
    // 所以可以存储下来 n f(n)
    // 如果有值，则直接取；如果没有，再递归调用计算，并且保存。
    public static int jump2(int n) {

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
            int res = jump2(n - 1) + jump2(n - 2);
            nMap.put(n, res);
            return res;
        }
    }

    // 对于这种有递推关系的题，可以参考斐波那契数列
    public static int jump3(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

}
