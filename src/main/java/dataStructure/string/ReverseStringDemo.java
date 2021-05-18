package dataStructure.string;

/**
 * 反转字符串
 *
 * @author Shadowalker
 */
public class ReverseStringDemo {
    public static void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while (i <= j && i <= length >> 1) {
            char tmp;
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }
}
