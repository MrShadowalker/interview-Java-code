package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序算法检查
 * 1. 产生足够多的随机样本
 * 2. 用确定正确的算法计算样本结果
 * 3. 对比被验证的算法的结果
 * 4. 循环多次，确保正确
 *
 * @author Shadowalker
 */
public class SortCheckDemo {

    public static void main(String[] args) {
        check();
    }

    private static void check() {
        int[] arr0 = generateRandomArray();
        int[] arr1 = new int[arr0.length];
        System.arraycopy(arr0, 0, arr1, 0, arr0.length);

        // int[] arr1 = generateRandomArray();

        // 循环 3 次，确保正确
        for (int i = 0; i < 3; i++) {

            Arrays.sort(arr0);
            // SelectionSortDemo.sort(arr1);
            // BubbleSortDemo.sort(arr1);
            // BubbleSortDemo.sort2(arr1);
            // InsertionSortDemo.sort(arr1);
            // InsertionSortDemo.sort2(arr1);
            // ShellSortDemo.sort(arr1);
            // MergeSortDemo.sort(arr1, 0, arr1.length - 1);
            // QuickSortDemo.sort(arr1, 0, arr1.length - 1);
            CountSortDemo.sort(arr1);

            boolean isSame = false;
            for (int j = 0; j < arr0.length; j++) {
                isSame = arr0[j] == arr1[j] ? true : false;
            }
            System.out.println(isSame == true ? "right" : "wrong");
        }

    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
