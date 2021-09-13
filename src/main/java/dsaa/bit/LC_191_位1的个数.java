package dsaa.bit;


import java.util.Arrays;
import java.util.List;


//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

//    请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//    在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。

//    输入：00000000000000000000000000001011
//    输出：3
//    解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//    示例 2：
//
//    输入：00000000000000000000000010000000
//    输出：1
//    解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//    示例 3：
//
//    输入：11111111111111111111111111111101
//    输出：31
//    解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//    提示：
//    输入必须是长度为 32 的 二进制串 。
//    进阶：
//
//    如果多次调用这个函数，你将如何优化你的算法？


/**
 * @author zhf
 * @since 2021/5/30 10:32 下午
 **/
public class LC_191_位1的个数 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1024, 88, 999, 1000234, 623452);
        LC_191_位1的个数 lc = new LC_191_位1的个数();
        list.forEach(x -> System.out.print(lc.hammingWeight(x) + " "));
        System.out.println("jdk");
        list.forEach(x -> System.out.print(lc.hammingWeightUseBit(x) + " "));
        System.out.println("bit");
        list.forEach(x -> System.out.print(lc.hammingWeightUseBitOpt(x) + " "));
        System.out.println("bit");
        list.forEach(x -> System.out.print(lc.hammingWeightRubbish(x) + " "));
        System.out.println("for rubbish");
    }

    /**
     * jdk方法
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 假设n 为 111100111
     * 左移运算符 <<
     * 1     111100111
     * 10    111100111
     * 100   111100111
     * 1000  111100111
     * 10000 111100111
     * 依次比较每一位
     *
     * @param n
     * @return
     */
    public int hammingWeightUseBit(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * n = 15
     * n & n - 1 = 14 1111 1110 = 1110
     * n & n - 1 = 12 1110 1101 = 1100
     * n & n - 1 = 4  1100 1011 = 1000
     * n & n - 1 = 0  1000 0111 = 0000
     *
     * 这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，
     * 我们不断让当前的 nn 与 n - 1n−1 做与运算，直到 nn 变为 00 即可。
     * 因为每次运算会使得 nn 的最低位的 11 被翻转，因此运算次数就等于 nn 的二进制位中 11 的个数。
     *
     * 时间复杂度：O(\log n) 循环次数等于 nn 的二进制位中 11 的个数，最坏情况下 nn 的二进制位全部为 11。
     * 空间复杂度：O(1) 我们只需要常数的空间保存若干变量。
     * @param n
     * @return
     */
    public int hammingWeightUseBitOpt(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


    /**
     * 转二进制 判断1的个数
     * 垃圾
     *
     * @param n
     * @return
     */
    public int hammingWeightRubbish(int n) {
        int count = 0;
        String binaryString = Integer.toBinaryString(n);
        // 10000
        for (char bit : binaryString.toCharArray()) {
            if (((bit - '0') & 1) == 1) {
                count++;
            }
        }
        return count;
    }


}
