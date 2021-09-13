package 剑指offer;


//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
//        示例 1:
//
//        输入: n = 1
//        输出: [1,2,3,4,5,6,7,8,9]
//         
//
//        说明：
//
//        用返回一个整数列表来代替打印
//        n 为正整数

import util.ArrayUtil;

import java.util.stream.IntStream;

/**
 * @author zhf
 * @since 2021/4/18 8:53 下午
 **/
public class JZ_17 {

    public static void main(String[] args) {
        JZ_17 jz = new JZ_17();
        int n = 3;
        jz.printIntegerNumbers(n);
        n = 10;
        jz.printNumbers(n);
    }

    /**
     * 不考虑大数的时候
     * 10的n次方-1
     * @param n
     * @return
     */
    public int[] printIntegerNumbers(int n) {
        int max = (int) Math.pow(10,n) - 1;
        int[] nums = IntStream.rangeClosed(1, max).toArray();
        ArrayUtil.printArray(nums,"end");
        return nums;
    }

    /**
     * 考虑大数的时候
     */
    public int[] printNumbers(int n) {
        int nums[] = new int[]{1,2,3};
        ArrayUtil.printArray(nums,"end");
        return nums;
    }



}
