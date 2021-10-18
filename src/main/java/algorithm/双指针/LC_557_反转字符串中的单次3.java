package algorithm.双指针;
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"

//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 双指针 字符串
// 👍 341 👎 0

/**
 * User: sam_zhan
 * DateTime: 2021/10/9 4:40 下午
 */
public class LC_557_反转字符串中的单次3 {
    public static void main(String[] args) {
        LC_557_反转字符串中的单次3 lc = new LC_557_反转字符串中的单次3();
        String s = "Let's take LeetCode contest";
        System.out.println(s);
        System.out.println(lc.reverseWords(s));
    }

    /**
     * 双指针
     * 每次找到单次的结尾 翻转单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int left = 0, right = 0;
        char[] array = s.toCharArray();
        for (; right < array.length; right++) {
            if (right == array.length - 1 || array[right + 1] == ' ') {
                // 翻转left到right这个区间的字符串
                int tempRight = right;
                while (left < tempRight) {
                    char temp = array[left];
                    array[left++] = array[tempRight];
                    array[tempRight--] = temp;
                }
                left = right + 2;
            }
        }
        return new String(array);
    }
}