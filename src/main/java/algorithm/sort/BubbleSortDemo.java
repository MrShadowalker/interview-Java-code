package algorithm.sort;

/**
 * 冒泡排序
 * 时间复杂度：O(n²)
 * 基本不用，太慢
 * 最好情况时间复杂度 O(n) 需要优化
 *
 * @author Shadowalker
 */
@SuppressWarnings("ALL")
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 1, 3, 7, 2, 4, 9};
        sort(arr);
        // sort2(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    // 马士兵冒泡
    static void sort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            findMax(arr, i);
        }
    }

    private static void findMax(int[] arr, int i) {
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
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
