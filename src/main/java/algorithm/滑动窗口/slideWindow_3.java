package algorithm.滑动窗口;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: sam_zhan
 * DateTime: 2020/10/10 7:13 下午
 */
public class slideWindow_3 {


    /**
     * 给定两个字符串 ​source​ 和 ​target​. 求 ​source​ 中最短的包含 ​target​ 中每一个字符的子串.
     * <p>
     * 如果没有答案, 返回 ​""​.
     * 保证答案是唯一的.
     * ​target​ 可能包含重复的字符, 而你的答案需要包含至少相同数量的该字符.
     * 这个题目说的是包含字符串的 只要求数量 不要求顺序
     *
     */

    public static void main(String[] args) {
        String source = "abddadcabc";
        String target = "abc";
        version1(source, target);
    }

    /**
     * 只求字符数量对 不求顺序的
     * @param source
     * @param target
     */
    private static void version1(String source, String target) {
        char[] sourceChar = source.toCharArray();
        char[] targetChar = target.toCharArray();
        // abcdegdddget 01234
        // degshg 01234
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> resultMap = new LinkedHashMap<>();
        int minLength = 0;
        int left = 0;
        int right = 0;
        // degshg 01234
        while (right < sourceChar.length) {
            for (int j = 0; j < targetChar.length; j++) {
                for (int i = left; i < sourceChar.length; i++) {
                    if (targetChar[j] == sourceChar[i]) {
                        // 找到第一个 继续第二个
                        resultMap.put(targetChar[j], i);
                        left = i;
                        break;
                    }
                    if (resultMap.size() == targetChar.length) {
                        System.out.println(resultMap);
                    }
                }
                j = 0;
            }
        }
    }
    /**
     * 字符串顺序也一致的子串
     */
    public static void version2(String source, String target){
    }
}