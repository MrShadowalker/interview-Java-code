package datastructure.array;

/**
 * Leetcode 485
 * 最大连续 1 的个数
 * <p>
 * 给定一个二进制数组，计算其中最大连续 1 的个数。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 提示：
 * <p>
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class FindMaxConsecutiveOnesDemo {

    public static void main(String[] args) {
        int[] req = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        int res = findMaxConsecutiveOnes(req);
        System.out.println(res);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                result = Math.max(count, result);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(count, result);
    }
}
