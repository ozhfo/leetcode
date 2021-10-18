package algorithm.双指针;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//
//
// 示例 1：
//
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
//
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 105
// s[i] 都是 ASCII 码表中的可打印字符
//
// Related Topics 递归 双指针 字符串
// 👍 467 👎 0



import util.ArrayUtil;

import java.util.Arrays;

/**
 * User: sam_zhan
 * DateTime: 2021/10/9 4:40 下午
 */
public class LC_344_反转字符串 {
    public static void main(String[] args) {
        LC_344_反转字符串 lc = new LC_344_反转字符串();
        String s = "1234567890";
        lc.reverseString(s.toCharArray());
        char[] array = lc.reverseString2(s.toCharArray(), 0, s.toCharArray().length - 1);
        ArrayUtil.printArray(array, "递归");

    }

    /**
     * 双指针
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        ArrayUtil.printArray(s,"双指针");
    }

    /**
     * 递归
     */
    public char[] reverseString2(char[] s, int left, int right) {
        if(left < right){
            reverseString2(s, left+1, right-1);
        }
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        return s;
    }


}