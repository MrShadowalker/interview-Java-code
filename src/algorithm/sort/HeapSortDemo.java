package algorithm.sort;

import static java.lang.System.out;

/**
 * 堆排序
 *
 * @author Shadowalker
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        int[] arr1 = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        int[] arr2 = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        int[] arr3 = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort1(arr1);
        sort2(arr2);
        sort3(arr3);
        print(arr1);
        print(arr2);
        print(arr3);
    }

    /**
     * 经典堆排序
     *
     * @param arr
     */
    private static void sort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }

    private static void heapInsert(int[] arr, int i) {
    }

    private static void sort2(int[] arr) {

    }

    public static void sort3(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            // 将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            // 重新对堆进行调整
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        /**
         * 先取出当前元素i
         */
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            /**
             * 如果左子结点小于右子结点，k指向右子结点
             */
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            /**
             * 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
             */
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        /**
         * 将temp值放到最终的位置
         */
        arr[i] = temp;
    }

    private static void print(int[] arr) {
        for (int j : arr) {
            out.print(j + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

// TODO
class MaxHeapDemo {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public MaxHeapDemo(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("堆已满，无法插入。");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    private void heapInsert(int[] heap, int i) {

    }
}