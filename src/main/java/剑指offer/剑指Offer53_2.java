package 剑指offer;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 0～n-1中缺失的数字
 * User: sam_zhan
 * DateTime: 2021/9/20 9:59 上午
 */
public class 剑指Offer53_2 {

    public static void main(String[] args) {
        剑指Offer53_2 jz = new 剑指Offer53_2();
        int[] nums = new int[]{0, 1, 3, 4, 5, 6, 7,8,9};
        System.out.println(jz.missingNumber(nums));
        System.out.println(jz.missingNumber2(nums));
        System.out.println(jz.missingNumber3(nums));
    }

    /**
     * 递增 排序 数组 唯一
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        // 二分法
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 对于有序数组, 大小为i的数应当处于下标为i的位置上, 如果不在, 说明在该数字之前发生了错位
            int mid = (left + right) / 2;
            // 数组下标是从0开始连续的向n增长，若相等范围区域继续向右靠
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                // 不相范围区域向左靠拢
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 累加和相减
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums){
        return IntStream.rangeClosed(0,nums.length).sum() - Arrays.stream(nums).sum();
    }

    /**
     * for循环
     */
    public int missingNumber3(int[] nums){
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return i;
    }

    /**
     *
     */
}