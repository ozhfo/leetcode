package 剑指offer;


//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 字符串
// 👍 105 👎 0


import java.util.stream.IntStream;

/**
 * @author zhf
 * @since 2021/4/10 2:59 下午
 **/
public class JZ_58_2 {

    // https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/

    public static void main(String[] args) {
        String old = "abcdefghijklmnopqrst";
        IntStream.rangeClosed(1, 10).forEach(x -> System.out.println(reverseLeftWords(old, x)));
    }

    /**
     * substring
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * StringBuilder
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    /**
     * StringBuilder 取余
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2P(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();

    }

    /**
     * + 这里会重复创建String
     */
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }


    /**
     * 三步反转
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords4(String s, int n) {
        int length = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, length - 1);//先反转全部的元素
        reverse(chars, 0, length - n - 1);//在反转前length - n个元素
        reverse(chars, length - n, length - 1);//接着反转剩余的
        return new String(chars);
    }


    //把数组中从[start，end]之间的元素两两交换,也就是反转
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }



}

