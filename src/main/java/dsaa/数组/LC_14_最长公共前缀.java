package dsaa.数组;

//编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。

//输入：strs = ["flower","flow","flight"]
//输出："fl"
//

//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1813 👎 0




/**
 * User: sam_zhan
 * DateTime: 2021/10/13 7:50 下午
 */
public class LC_14_最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        LC_14_最长公共前缀 lc = new LC_14_最长公共前缀();
        System.out.println("最佳:" + lc.longestCommonPrefix(strs));
        System.out.println("横向比较:" + lc.longestCommonPrefix2(strs));
        System.out.println("纵向比较:" + lc.longestCommonPrefix3(strs));
    }

    /**
     * 解法1
     * 确定一个基准字符串 然后往后匹配 看是否存在 如果存在继续 不存在长度减1
     * abcd abc ab a
     * 只要求公共前缀？
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String baseStr = strs[0];
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

    /**
     * 同解法1
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String getPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    /**
     * abcdefg
     * abcwerfasf
     * abersf
     * abdesd
     * 纵向比较 比较第一个 第二个 第三个
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }




}