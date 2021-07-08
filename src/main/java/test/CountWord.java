package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 文本词条计数器
 *
 * @author Shadowalker
 */
public class CountWord {

    public static void main(String[] args) throws FileNotFoundException {
        // 判断文件是否为空
        // File file = new File("If not now when   if not me who ");
        File file = new File("CountWordTest.txt");

        // 扫描器
        Scanner scanner = new Scanner(file);

        // 创建哈希表
        HashMap<String, Integer> hashTable = new HashMap<String, Integer>();

        while (scanner.hasNextLine()) {
            String lineString = scanner.nextLine();
            // 正则匹配非单词字符，分割为一个个的单词，组成字符数组
            String[] wordArray = lineString.split("\\W+");

            Set<String> wordSet = hashTable.keySet();

            for (String s : wordArray) {
                // 如果存在
                if (wordSet.contains(s)) {
                    Integer count = hashTable.get(s);
                    count++;
                    hashTable.put(s, count);
                } else {
                    hashTable.put(s, 1);
                }
            }
        }

        System.out.println("----------word count list----------");
        // 遍历hashTable 打印： 单词 出现次数
        for (Map.Entry<String, Integer> entry : hashTable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("-----------------------------------");
    }
}
