package dataStructure.array;

/**
 * Leetcode 189
 * 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class RotateArrayDemo {
    public static void main(String[] args) {
        System.out.println("++++++++++");

        int[] nums1 = initArray();
        rotate1(nums1, 3);
        print(nums1);

        int[] nums2 = initArray();
        rotate2(nums2, 3);
        print(nums2);

    }

    private static int[] initArray() {
        int[] nums = new int[7];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        return nums;
    }

    private static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
        System.out.println("++++++++++");
    }

    // 暴力解法：切分，重新拼接
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        int offset = length - k % length;
        int[] offsets = new int[offset];
        for (int i = 0; i < offset; i++) {
            offsets[i] = nums[i];
        }
        for (int i = offset, j = 0; i < length; i++, j++) {
            nums[j] = nums[i];
        }
        for (int i = length - offset, j = 0; i < length; i++, j++) {
            nums[i] = offsets[j];
        }
    }

    // 聪明点的办法
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    // 环状替换
    // 使用额外数组的原因在于如果我们直接将每个数字放至它最后的位置，这样被放置位置的元素会被覆盖从而丢失。
    // 因此，从另一个角度，我们可以将被替换的元素保存在变量 temp 中，从而避免了额外数组的开销。
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // 使用单独的变量 count 跟踪当前已经访问的元素数量，当 count = n 时，结束遍历过程。
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    // 最大公约数
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    // 数组翻转
    public static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 翻转数组
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
