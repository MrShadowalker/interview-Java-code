package algorithm.string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author Shadowalker
 */
public class LongestCommonPrefixDemo {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String commonPrefix = longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != tmp) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
