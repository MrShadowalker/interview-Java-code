package algorithm.sort;

/**
 * 选择排序
 * 时间复杂度 O(n²)
 * 基本不用，不稳（相同的值可能交换位置）
 * 选中未排序的第一个数，向后比较选择最小的数，交换位置。向后遍历。
 * 优化 1：在找出最小数放在队首，同时找出最大数放在队尾，减少一半的遍历
 * 优化 2：……
 *
 * @author Shadowalker
 */
public class SelectionSortDemo {

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 1, 3, 7, 2, 4, 9};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            // System.out.println("minPos:" + minPos);
            swap(arr, i, minPos);
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
