package algorithm.sort;

import java.util.Random;

/**
 * 计数排序
 * 桶思想
 * 大量数据在有限的范围
 *
 * @author Shadowalker
 */
public class CountSortDemo {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 0, 5, 2, 4};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] countArr = new int[findMax(arr) + 1];

        for (int k : arr) {
            countArr[k]++;
        }
        // print(countArr);
        // System.out.println("");

        for (int i = 0, j = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                result[j++] = i;
            }
        }

        // print(result);
        // System.out.println("");

        for (int i = 0; i < result.length; i++) arr[i] = result[i];
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // System.out.println(max);
        return max;
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
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
