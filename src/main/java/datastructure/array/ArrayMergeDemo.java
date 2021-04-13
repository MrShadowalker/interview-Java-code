package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class ArrayMergeDemo {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // {{1,3}, {1, 6}, {8,10}, {15,18}}
        // 0 1 0
        // 1 1 1
        // 1 2 1
        // 1 3 1
        // 2 3 1
        // int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] intervals3 = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        // 1-3 2-2 2-2 2-3 3-3 4-6 5-7
        // 1-3 4-6 5-7
        // 1-3 4-7
        int[][] result1 = merge(intervals3);
        for (int i = 0; i < result1.length; i++) {
            for (int j = 0; j < result1[i].length; j++) {
                System.out.println(result1[i][j]);
            }
        }

        // int[][] result2 = merge(intervals2);
        // System.out.println(result2);
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }
        // 按每行的第0列升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> resultList = new ArrayList<>();

        int[] flag = intervals[0];
        for (int i = 1; i < length; i++) {
            if (flag[1] >= intervals[i][0]) {
                flag[1] = Math.max(flag[1], intervals[i][1]);
            } else {
                resultList.add(flag);
                flag = intervals[i];
            }
        }
        resultList.add(flag);

        int[][] result = new int[resultList.size()][2];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

}
