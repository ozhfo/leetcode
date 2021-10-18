package algorithm.滑动窗口;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

//
//输入: s = ""
//输出: 0
//

// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 6267 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: sam_zhan
 * DateTime: 2021/10/11 9:26 下午
 */
public class LC_3_无重复字符的最长子串 {

    public static void main(String[] args) {
        LC_3_无重复字符的最长子串 lc = new LC_3_无重复字符的最长子串();
        System.out.println(lc.lengthOfLongestSubstring("123143"));
        System.out.println(lc.lengthOfLongestSubstring2("123145"));
        System.out.println(lc.lengthOfLongestSubstring3("121315213"));
    }

    /**
     * 双重for
     * 找最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                // 利用map 如果不存在加1 如果已存在本轮结束
                if (!map.containsKey(array[j])) {
                    map.put(array[j], 1);
                } else {
                    break;
                }
            }
            //当前子串结束 判断当前子串是否未最大子串
            maxLength = map.size() > maxLength ? map.size() : maxLength;
            if (maxLength >= array.length - i) {
                // 当前最长已经超过后面的整个长度 那么没必要再继续了
                break;
            }
            map.clear();
        }
        return maxLength;
    }

    /**
     * 假设i->j这个范围是ok的
     * 然后在i->j+1的时候重复了 那么i=i+1
     * 此时i+1->j这个是不重复的j右可以继续移动了
     * 如果j移动0个 那么继续i+1
     * 如果j移动1个 maxLength不变 然后i+1;
     * 如果j移动2个 maxLength变大
     * 滑动窗口
     *
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, maxLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            maxLength = Math.max(maxLength, rk - i + 1);
        }
        return maxLength;
    }
}