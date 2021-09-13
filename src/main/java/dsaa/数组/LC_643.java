package dsaa.数组;


//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//         
//
//        示例：
//
//        输入：[1,12,-5,-6,50,3], k = 4
//        输出：12.75
//        解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//         
//
//        提示：
//
//        1 <= k <= n <= 30,000。
//        所给数据范围 [-10,000，10,000]。


/**
 * @author zhf
 * @since 2021/4/24 12:29 上午
 **/
public class LC_643 {

    public static void main(String[] args) {
        int nums[] = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        LC_643 lc = new LC_643();
        lc.findMaxAverage(nums,4);
    }


    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        return 0;
    }

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {
        return 0;
    }

}
