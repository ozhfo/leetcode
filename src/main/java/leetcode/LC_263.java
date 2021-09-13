package leetcode;

//给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 6
//输出：true
//解释：6 = 2 × 3
//
// 示例 2：
//
//
//输入：n = 8
//输出：true
//解释：8 = 2 × 2 × 2
//
//
// 示例 3：
//
//
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
//
//
// 示例 4：
//
//
//输入：n = 1
//输出：true
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
// Related Topics 数学
// 👍 227 👎 0


/**
 * @author zhf
 * @since 2021/4/10 3:47 下午
 **/
public class LC_263 {

    public static void main(String[] args) {
        int n = 100000234;
    }
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    /**
     * 根据丑数的定义，00 和负整数一定不是丑数。
     * 为判断 nn 是否满足上述形式，可以对 nn 反复除以 2,3,52,3,5，
     * 直到 nn 不再包含质因数 2,3,52,3,5。若剩下的数等于 11，则说明 nn 不包含其他质因数，是丑数；
     * 否则，说明 nn 包含其他质因数，不是丑数。
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

}
