package datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode 20
 * <p>
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shadowalker
 */
public class IsValidDemo {
    public static void main(String[] args) {
        String s1 = "()[]}{";
        // String s2 = "()]";
        // String s3 = "{[()]}";
        boolean b1 = isValid(s1);
        // boolean b2 = isValid(s2);
        // boolean b3 = isValid(s3);
        System.out.println("s1:" + b1);
        // System.out.println("s2:" + b2);
        // System.out.println("s3:" + b3);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // 遇到左括号就把对应的右括号压栈
        // 遇到右括号，栈不能为空，否则 false；若不为空，则出栈匹配
        for (char c : chars) {
            if (pairs.containsKey(c)) {
                stack.push(pairs.get(c));
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }


}
