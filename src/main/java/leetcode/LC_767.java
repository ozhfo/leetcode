package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC_767 {

    /**
     * TODO@LC
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     *
     * 输入: S = "aab"
     * 输出: "aba"
     * 示例 2:
     *
     * 输入: S = "aaab"
     * 输出: ""
     * 注意:
     *
     * S 只包含小写字母并且长度在[1, 500]区间内。
     *
     */

    public static void main(String[] args) {
        Solution("aaaabdddeefffggssaajhjiiwersddsewssssa");
    }




    /**
     * 先判断是否可行
     * 然后找到满足条件的结果
     * 1 2 2 3 -> 1212
     * 1 2 2 2 3 -> 2 6 2 3 2
     * 222 444 555 245245245
     * 222 1 1
     * 222 1 不行
     * 2 10个
     * 3 5个
     * 4 2个
     * 5 3 2
     * 5 1 1 1 1
     * 5 2 1 1
     * 333
     * abcabcabc
     * abababacac
     * abc abc ab aaa
     * ab ab ab ab cac
     * b a b a b a b a b c a c
     * @param str
     */
    public static void Solution(String str) {
        char [] array = str.toCharArray();
        int[] alphabetCount = new int[26];
        //统计每个字符出现的次数
        for (int j = 0; j < str.length();j++) {
            alphabetCount[array[j] - 'a']++;
        }
        System.out.println("count");
        for(int i = 0; i < alphabetCount.length; i++){
            System.out.println("char " + (char)(i + 'a') +" count = " + alphabetCount[i]);
        }
        // 找到出现次数最多的字符
        // 填充 试探

    }

    /**
     * 不要用包装类型
     * 不要天天想着用Stream 沙比
     *
     * @param str
     */
    public static void SolutionZhf(String str) {
        Character[] array = new Character[str.length()];
        int i = 0;
        for (Character character : str.toCharArray()) {
            array[i++] = character;
        }

        int alphabetCount[] = new int[26];
        //统计每个字符出现的次数
        for (int j = 0; i < str.length();j++) {
            alphabetCount[array[j] - 'a']++;
        }
        System.out.println("count");
        Arrays.stream(alphabetCount).forEach(System.out::println);


        Map<Character, List<Character>> map = Arrays.asList(array).stream()
                .collect(Collectors.groupingBy(x -> x,TreeMap::new, Collectors.toList()));
        System.out.println(map.toString());

        List<Map.Entry<Character, List<Character>>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, (o1, o2) -> o1.getValue().size() > o2.getValue().size() ? -1 : 1);
        System.out.println("list = " + list);

        Integer maxSize = list.get(0).getValue().size();
        Integer totalSize = str.length();
        if(maxSize > totalSize / 2){
            System.out.println("无法处理");
        }
    }
}
