package algorithm.array;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心下标可能出现在数组的两端。
 * <p>
 * 提示：
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class ArrayMiddlePivotDemo {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};
        int pivot1 = pivotIndex(nums1);
        int pivot2 = pivotIndex(nums2);
        int pivot3 = pivotIndex(nums3);
        System.out.println(pivot1);
        System.out.println(pivot2);
        System.out.println(pivot3);
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        int tempSum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum - nums[0] == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];

            if (i != 0) {
                leftSum = tempSum - nums[i];
            }
            while (sum - tempSum == leftSum) return i;
        }
        return -1;
    }
}
