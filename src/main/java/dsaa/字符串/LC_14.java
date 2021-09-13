package dsaa.字符串;

//编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。

//输入：strs = ["flower","flow","flight"]
//输出："fl"

//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。

//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1615 👎 0

import java.util.*;

/**
 * @author zhf
 * @since 2021/5/24 10:02 下午
 **/
public class LC_14 {

    public static void main(String[] args) {
//        String[] strs = new String[]{"flow","flower","flight"};
        String[] strs = new String[]{"dog","racecar","car"};
        LC_14 lc = new LC_14();
        System.out.println("最长公共前缀:" + lc.longestCommonPrefix(strs));
    }

    /**
     * 确定一个基准字符串 然后往后匹配 看是否存在 如果存在继续 不存在长度减1？
     * abcd abc ab a
     * 只要求公共前缀？
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String baseStr = strs[0];  // 基准字符串
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(baseStr) != 0) {
                if (baseStr.length() == 0) {
                    return "";
                }
                baseStr = baseStr.substring(0,baseStr.length() - 1);
            }
        }
        return baseStr;
    }



    public String longestCommonPrefix(String[] strs) {
        //TODO 排序不生效
        Arrays.stream(strs).sorted(strLengthComparator.reversed());
        List<String> possiblePrefix = getPrefix(strs[0]);
        int i = possiblePrefix.size() - 1;
        for (; i >= 0; i--) {
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].contains(possiblePrefix.get(i))) {
                    possiblePrefix.remove(i);
                    break;
                }
            }
        }
        System.out.println("asdfasdfa");
        if (possiblePrefix.size() > 0) {
            possiblePrefix.sort(Comparator.comparing(String::length).reversed());
            possiblePrefix.stream().forEach(System.out::println);
            return possiblePrefix.get(0);
        }
        return "";
    }

    // 假设只有1个字母匹配 得出来的结论是啥 是a 还是 l 还是x 还是y
    // laxy  lax  la   l
    // axy ax a
    // xy x
    // y

    /**
     * 拿到所有可能的子串
     *
     * @param str
     * @return
     */
    private List<String> getPrefix(String str) {
        List<String> possibleKeys = new ArrayList<>();
        char[] strChars = str.toCharArray();
        for (int i = 0; i < strChars.length; i++) {
            for (int j = i; j < strChars.length; j++) {
                possibleKeys.add(str.substring(i,j+1));
            }
        }
        possibleKeys.stream().forEach(System.out::println);
        return possibleKeys;
    }



    Comparator<String> strLengthComparator = (o1, o2) -> {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() == o2.length()) {
            return 0;
        } else {
            return -1;
        }
    };


}

