package algorithm.sort;

import java.util.Random;

/**
 * 希尔排序
 * 优化的插入排序
 * eg：设置间隔为 4，依次插入排序；再设置间隔为 2，依次插入排序；再设置间隔为 1，插入排序。
 * 优化点：间隔大的时候，交换次数少；间隔小的时候，交换距离短。
 *
 * @author Shadowalker
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr) {

        /**
         * 间隔序列暂且设置 gap = arr.length/2，但其实还有更好的。
         * Knuth 序列
         * h = 1
         * h = 3h + 1
         */
        int h = 1;
        while (h <= arr.length / 3) {
            h = 3 * h + 1;
        }
        // for (int gap = arr.length / 2; gap > 0; gap /= 2) {
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}