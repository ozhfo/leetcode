package dsaa.bit;


import java.util.Arrays;
import java.util.List;

// 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//        如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
//        输入：n = 1
//        输出：true
//        解释：20 = 1
//        示例 2：
//
//        输入：n = 16
//        输出：true
//        解释：24 = 16
//        示例 3：
//
//        输入：n = 3
//        输出：false
//        示例 4：
//
//        输入：n = 4
//        输出：true
//        示例 5：
//
//        输入：n = 5
//        输出：false
//         
//        提示：
//        -2^31 <= n <= 2^31 - 1
// 进阶：你能够不使用循环/递归解决此问题吗？

/**
 * @author zhf
 * @since 2021/5/30 10:32 下午
 **/
public class LC_231_2的幂 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 1, 2, 3, 4, 5, 8, 10, 20, 30);
        LC_231_2的幂 lc = new LC_231_2的幂();
        list.forEach(x -> System.out.print(lc.isPowerOfTwo(x) + " "));
        System.out.println("常规");
        list.forEach(x -> System.out.print(lc.isPowerOfTwoUseBit(x) + " "));
        System.out.println("位运算");
        list.forEach(x -> System.out.print(lc.isPowerOfTwoUseBit2(x) + " "));
        System.out.println("位运算2");
        list.forEach(x -> System.out.print(lc.isPowerOfTwoUseCondition(x) + " "));
        System.out.println("结合条件");

    }

    /**
     * 常规解法
     * 1.排除边界 <= 0
     * 2.如果是2的幂：取模为0且能除尽
     * 64 32 16 8 4 2 1
     * 60 30 15
     * 3.判断n是否为1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            //能取余的做除法 不能的说明分子里面有奇数
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 位运算
     * 如果一个数是2的幂 那么满足：n为正整数且n的二进制只有最低位是1个1 其他位都是0
     * 且 n-1 刚好反过来
     * 16 10000  8 1000
     * 15 01111  7 0111
     * 解法1： n & (n - 1) == 0
     * 解法2： Integer.bitCount(n)==1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwoUseBit(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwoUseBit2(int n) {
        return n > 0 && (n & (n - 1))== 0;
    }



    /**
     * 题目已经指定了 n的范围：-2^31 <= n <= 2^31 - 1
     * 那么指定最大值为2^30 如果n是2的幂 那么对n取模一定为0
     * 2^4 = 16  2^5= 32 2^6 = 64
     * @param n
     * @return
     */
    public boolean isPowerOfTwoUseCondition(int n){
        return n > 0 && BIG % n == 0;
    }

    static final int BIG = 1 << 30;
}
