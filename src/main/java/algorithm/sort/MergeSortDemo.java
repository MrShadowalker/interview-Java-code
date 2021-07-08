package algorithm.sort;

import java.util.Random;

import static java.lang.System.out;

/**
 * 归并排序
 * 时间复杂度 O(NlogN)
 * 递归调用
 * 也可以尝试一下迭代
 *
 * @author Shadowalker
 */
public class MergeSortDemo {

    public static void main(String[] args) {

        // 归并排序需要处理的场景要更复杂，递归的时候可以将原数组分割为更细粒度的小数组进行排序
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        // sort(arr);

        // 先把前后两段分别排好序的数组拿出来做 demo
        // int[] arrDemo = {1, 4, 7, 8, 3, 6, 9};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 分成两半
        int mid = left + (right - left) / 2;

        // 左边排序
        sort(arr, left, mid);

        // 右边排序
        sort(arr, mid + 1, right);

        merge(arr, left, mid + 1, right);
        // merge(arr, 1, 3, 5);
    }

    /**
     * 实现递归调用的归并排序
     * 按照刚才分析 demo 方法的优化方式，新增如下参数：
     * 左指针，右指针，右边界
     *
     * @param arr
     */
    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {

        int mid = rightPtr - 1;

        // 左指针右指针引入后，长度要重新计算
        int length = rightBound - leftPtr + 1;

        int[] temp = new int[length];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        // 还需要考虑数组排序偏移，前后如果还有剩余，直接将剩余部分拼接到结果数组中即可
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        for (int a = 0; a < temp.length; a++) arr[leftPtr + a] = temp[a];

        // print(temp);
    }

    /**
     * 以下为非递归的 demo，可实现非递归的一次性排序，但是可用性不太行，没有实现递归
     * 转换思路：把针对一个完整的数组的排序方式，转化为可以针对任意长度的数组进行排序
     * 所以需要在入参中增加一些参数，并且增加递归调用的入口
     *
     * @param arr
     */
    private static void mergeDemo(int[] arr) {
        // 这里可以优化为右移 >> 1
        int mid = arr.length / 2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < arr.length) {
            temp[k] = Math.min(arr[i], arr[j]);
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 还需要考虑数组排序便宜，前后如果还有剩余，需要单独再处理
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j < arr.length) {
            temp[k++] = arr[j++];
        }

        // 输出结果
        print(temp);
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
        // int tmp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = tmp;

        // 骚一点的方式——异或
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
