package algorithm.sort;

import java.util.Random;

import static java.lang.System.out;

/**
 * 基数排序
 * 多关键字
 * 场景：数组，先按照个位数排，再按照十位数、百位数……
 * 应用场景不太多，先掌握思想即可，暂不实现。
 *
 * @author Shadowalker
 */
public class RadixSortDemo {
    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 124};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
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
            out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
