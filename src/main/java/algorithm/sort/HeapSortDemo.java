package algorithm.sort;

/**
 * 堆排序
 *
 * @author Shadowalker
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        // int[] arr1 = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        int[] arr2 = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        // sort1(arr1);
        sort2(arr2);
        // print(arr1);
        print(arr2);
    }

    /**
     * 经典堆排序
     * 堆排序额外空间复杂度 O(1)
     *
     * @param arr
     */
    private static void sort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("arr doesn't need to sort");
            return;
        }

        // 假设每次都是用户新给你的数，按照大根堆插入
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }

        // 优化：自下而上，每次大根堆化即可
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     System.out.println("heapify begin...");
        //     heapify(arr, i, arr.length);
        //     print(arr);
        // }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        // O(NlogN)
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * arr[index]刚来的数，往上
     *
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void sort2(int[] arr) {
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
     * 从 index 位置，往下不断下沉
     * 停止：孩子不再比自己大，或者已经没有孩子了
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = left + 1;

        while (left < heapSize) {
            // 左右两个孩子谁大就把自己下标给 largest
            // 右 -> 1. 有右孩子 2. 右孩子值比左孩子大
            // 否则，左
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;

            // 判断自己孩子和自己谁大谁小，如果左右孩子里面较大的值比自己大，则交换位置
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            // 交换后继续下沉，继续找下面的孩子
            index = largest;
            left = index * 2 + 1;
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
        for (int i : arr) {
            System.out.print(i + " ");
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