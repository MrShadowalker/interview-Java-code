package dataStructure.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 217
 * <p>
 * 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class ContainsDuplicateDemo {
    public static void main(String[] args) {
        int[] req = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate2(req));
    }

    // 用哈希集合
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> table = new HashSet<>();
        for (int i : nums) {
            if (!table.add(i)) {
                return true;
            }
        }
        return false;
    }

    // 玩个花的
    public static boolean containsDuplicate2(int[] nums) {
        int length = nums.length;
        int count = (int) Arrays.stream(nums).distinct().count();
        return length != count;
    }
}
