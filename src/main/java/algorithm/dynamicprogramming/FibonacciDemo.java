package algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 *
 * @author Shadowalker
 */
public class FibonacciDemo {

    // 1，1， 2，3，5，8，13……

    public static void main(String[] args) {
        // 打印前 n 位的斐波那契数列
        int length = 10;
        int[] res1 = new int[length];
        int[] res2 = new int[length];
        System.out.println(fibMain1(length, res1) > fibMain2(length, res2));
        int res = fibByDP(10);
        System.out.println("用动态规划方法算得的第" + "length 位为：" + res);
    }

    // 递归调用
    private static long fibMain1(int length, int[] res1) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            res1[i] = fibonacci(i);
        }
        // for (int i : res1) {
        //     System.out.println(i);
        // }
        long duration = System.currentTimeMillis() - start;
        System.out.println("递归方法，共用时：" + duration + "ms");
        return duration;
    }

    // 备忘录
    private static Map<Integer, Integer> map = new HashMap<>();

    // 带备忘录的递归方法
    private static long fibMain2(int length, int[] res1) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            res1[i] = fibWithDic(i);
        }
        // for (int i : res1) {
        //     System.out.println(i);
        // }
        long duration = System.currentTimeMillis() - start;
        System.out.println("动态规划，共用时：" + duration + "ms");
        return duration;
    }

    // 递归方法，返回斐波那契数组第 N 位的值
    public static int fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 优化，把之前的计算结果用 Map 保存起来
    public static int fibWithDic(int n) {
        if (n < 2) {
            map.put(n, 1);
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = fibWithDic(n - 1) + fibWithDic(n - 2);
        map.put(n, res);
        return res;
    }

    // 动态规划
    public static int fibByDP(int n) {
        int[] dic = new int[n];
        dic[0] = dic[1] = 1;
        for (int i = 2; i < n; i++) {
            dic[i] = dic[i - 1] + dic[i - 2];
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(dic[i]);
        // }
        return dic[n - 1];
    }
}
