package algorithm.test;

/**
 * 36 进制加法
 * <p>
 * 36 进制由 0-9，a-z，共 36 个字符表示。
 * <p>
 * 要求按照加法规则计算出任意两个 36 进制正整数的和，如 1b + 2x = 48  （解释：47 + 105 = 152）
 * <p>
 * 要求：不允许使用先将 36 进制数字整体转为 10 进制，相加后再转回为 36 进制的做法
 * <p>
 * 此题难度倒不是很大，实际上是 LC415. 字符串相加的扩展。
 * <p>
 * LC415 是十进制的大数相加，而本题是36进制的大数相加。
 *
 * @author Shadowalker
 */
public class AddBy36Demo {

    public static void main(String[] args) {

        String num1 = "1b";
        String num2 = "2x";
        String num3 = addBy36(num1, num2);
        System.out.println(num3);

    }

    public static String addBy36(String num1, String num2) {

        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int tmp = 0;
        int n1, n2;

        while (i >= 0 || j >= 0) {
            n1 = i >= 0 ? getInt(num1.charAt(i)) : 0;
            n2 = j >= 0 ? getInt(num2.charAt(j)) : 0;

            int sum = n1 + n2 + tmp;

            res.append(getChar(sum % 36));

            tmp = sum / 36;

            i--;
            j--;
        }

        if (tmp != 0) {
            res.append('1');
        }
        return res.reverse().toString();
    }

    public static char getChar(int n) {
        if (n < 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    public static int getInt(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a' + 10;
        }
    }
}
