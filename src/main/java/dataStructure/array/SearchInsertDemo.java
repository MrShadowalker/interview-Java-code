package dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @author Shadowalker
 */
public class SearchInsertDemo {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;
        int result1 = searchInsert(arr, target1);
        int result2 = searchInsert(arr, target2);
        int result3 = searchInsert(arr, target3);
        int result4 = searchInsert(arr, target4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    public static int searchInsert(int[] nums, int target) {
        // 哈希表存放数组中每个元素的位置
        Map<Integer, Integer> table = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }
        if (table.containsKey(target)) {
            return table.get(target);
        }
        int index = 0;
        for (Integer i : table.keySet()) {
            if (i < target) {
                index++;
            }
        }
        return index;
    }
}
