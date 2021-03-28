package algorithm.sort;

import java.util.Random;

/**
 * 快速排序
 * 分治法
 *
 * @author Shadowalker
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[end];
        int left = start;
        int right = end - 1;

        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            swap(arr, left, right);
        }

        if (arr[left] >= arr[end]) {
            swap(arr, left, end);
        } else {
            left++;
        }

        sort(arr, start, left - 1);
        sort(arr, left + 1, end);
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
