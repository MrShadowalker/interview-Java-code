package algorithm.dynamicprogramming;

/**
 * Leetcode 64
 * <p>
 * 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class MinPathSumDemo {
    public static void main(String[] args) {
        int[][] grip = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minSum = minPathSum(grip);
        System.out.println(minSum);
    }

    // TODO
    private static int minPathSum(int[][] grip) {
        int minSum = 0;


        return minSum;
    }
}
