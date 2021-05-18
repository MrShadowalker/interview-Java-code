package dataStructure.array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 * <p>
 * 提示：
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 *
 * @author Shadowalker
 */
public class ArrayPairSumDemo {
    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    public static int arrayPairSum(int[] nums) {
        // 首先将数组排序
        Arrays.sort(nums);
        // 打印排序结果，检查一下
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        //
        // }
        // System.out.println("");

        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count = count + nums[i];
        }
        return count;
    }

}
