package algorithm.sort;

/**
 * @author Shadowalker
 */ /* TODO 大根堆 */
@SuppressWarnings("ALL")
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

    /**
     * 返回大根堆中最大值。
     * 剩下的数，依然要保持大根堆组织。
     * heapSize 减少，意味着 heap 数组中有效位置减少，即代表仅 heapSize 长度的数字在其中是有效的。
     *
     * @return
     */
    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
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

    /**
     * 从 index 位置，往下不断下沉
     * 停止：孩子不再比自己大，或者已经没有孩子了
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    private void heapify(int[] arr, int index, int heapSize) {
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

    // 暴力法构造一个绝对正确的大根堆
    private static class RightMaxHeapDemo {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeapDemo(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("堆已满，无法插入。");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }
    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 10;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MaxHeapDemo my = new MaxHeapDemo(curLimit);
            RightMaxHeapDemo test = new RightMaxHeapDemo(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            System.out.println("Begin…");
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops1!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops2!");
                }
                if (my.isEmpty()) {
                    pushValue(value, my, test);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops3!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        pushValue(value, my, test);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops4!");
                        }
                    }
                }
            }
        }
        System.out.println("done!");
    }

    private static void pushValue(int value, MaxHeapDemo my, RightMaxHeapDemo test) {
        int curValue = (int) (Math.random() * value);
        my.push(curValue);
        test.push(curValue);
    }
}
