package algorithm.sort;

//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
// 👍 274 👎 0

import util.ArrayUtil;
import util.PrintUtil;

import java.util.Arrays;

/**
 * @author zhf
 * @since 2021/4/15 11:17 上午
 **/
public class LC_912 {

    public static void main(String[] args) {
        int nums[] = ArrayUtil.getShuffleArray(20);
        LC_912 lc = new LC_912();
        lc.BubbleSort(nums);
    }

    public void BubbleSort(int nums[]) {
        PrintUtil.bigPrintln("冒泡排序");
        // turn 轮次
        for (int turn = 0; turn < nums.length - 1; turn++) {
            // 比较j和j+1  结束之后最大的到最后
            for (int j = 0; j < nums.length - turn - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtil.swap(nums, j, j + 1);
                }
            }
        }
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
