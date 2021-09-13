package dsaa.bit;


import java.util.Arrays;
import java.util.List;


//   给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//   整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x

//   输入：n = 16
//   输出：true
//   示例 2：

//   输入：n = 5
//   输出：false
//   示例 3：
//   输入：n = 1
//   输出：true

//   -231 <= n <= 231 - 1

//   进阶：
//
//   你能不使用循环或者递归来完成本题吗？

/**
 * @author zhf
 * @since 2021/5/30 10:32 下午
 **/
public class LC_342_4的幂 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));
        List<Integer> list = Arrays.asList(-1, 1, 2, 3, 4, 5, 8, 10, 20, 30);
        LC_342_4的幂 lc = new LC_342_4的幂();
        list.forEach(x -> System.out.print(lc.isPowerOfFour(x) + " "));
        System.out.println("常规");
        list.forEach(x -> System.out.print(lc.isPowerOfTwoUseBit(x) + " "));
        System.out.println("位运算");
        list.forEach(x -> System.out.print(lc.isPowerOfTwoUseBit2(x) + " "));
        System.out.println("位运算2");
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            //能取余的做除法 不能的说明分子里面有奇数
            n /= 4;
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
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwoUseBit(int n) {
        return n > 0 && Integer.bitCount(n) == 1 && (Integer.toBinaryString(n).length() & 1) == 1;
    }

    /**
     * 4^0 = 1
     * 4^1 = 100
     * 4^2 = 10000
     * 所以满足n & (n - 1) == 0 && n > 0
     * 或者转成2进制之后是奇数 或者 n % 3 == 1
     * @param n
     * @return
     */
    public boolean isPowerOfTwoUseBit2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }



}
