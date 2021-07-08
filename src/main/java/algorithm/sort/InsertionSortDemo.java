package algorithm.sort;

import java.util.Random;

/**
 * 插入排序
 * 对基本有序的数组更快，样本小且基本有序的时候效率比较高，O(n)
 * 从第二个位置开始，与前面的值比较，如果小于前值，则插入到前面。
 * 优化：用临时变量记录标记项，去掉 swap 方法
 *
 * @author Shadowalker
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 1, 3, 7, 2, 4, 9};
        sort2(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            // for (int j = i; j > 0; j--) {
            // if (arr[j] < arr[j - 1]) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
                // }
            }
        }

    }

    // 临时变量记录
    public static void sort2(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
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
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // int tmp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = tmp;

        // 骚一点的方式——异或
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
