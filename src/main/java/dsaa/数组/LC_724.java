package dsaa.数组;


//       给你一个整数数组nums，请编写一个能够返回数组 “中心索引” 的方法。
//        数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
//        如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
//
//        注意：中心索引可能出现在数组的两端。
//
//         
//
//        示例 1：
//
//        输入：nums = [1, 7, 3, 6, 5, 6]
//        输出：3
//        解释：
//        索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//        同时, 3 也是第一个符合要求的中心索引。
//        示例 2：
//
//        输入：nums = [1, 2, 3]
//        输出：-1
//        解释：
//        数组中不存在满足此条件的中心索引。
//        示例 3：
//
//        输入：nums = [2, 1, -1]
//        输出：0
//        解释：
//        索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。
//        示例 4：

//        输入：nums = [0, 0, 0, 0, 1]
//        输出：4
//        解释：
//        索引 4 左侧数之和为 0 ；右侧不存在元素，视作和为 0 ，二者相等。
//
//        提示：
//        nums 的长度范围为[0, 10000]。
//        任何一个nums[i] 将会是一个范围在[-1000, 1000]的整数。


import com.alibaba.fastjson.JSON;
import util.PrintUtil;

import java.util.Arrays;

public class LC_724 {

    public static void main(String[] args) {
        int nums[][] = new int[][]{{1, 7, 3, 6, 5, 6},{1, 2, 3},{2,1,-1},{0,0,0,0,1}};
        LC_724 lc = new LC_724();
        for(int i = 0 ; i < nums.length; i++){
            System.out.println("数组是 " + JSON.toJSONString(nums[i]));
//            int index = lc.getSbPoint(nums[i]);
//            int index = lc.getMiddlePoint(nums[i]);
            int index = lc.pivotIndex(nums[i]);
            System.out.println("中心点是：" + index);
            PrintUtil.bigPrintln();
        }

    }

    /**
     * 击败100%
     * left = left + index
     * right = right - index
     * 直接极端情况 题目要求取最左 那么正序遍历第一个
     * index = 0 left = 0 right = total
     * index = 1 left += nums[0] right -= nums[0]
     * index = 2 left += nuns[1] right -= nums[0]
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        // right一开始等于全部 然后right缩小
        // left 一开始等于0 然后left一直加
        // 因为没有乘法
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for(int i = 0; i<nums.length; i++){
            rightSum = rightSum - nums[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * left + middle + right = total
     * left == right
     * left * 2 + middle = total
     * 这里有乘法 会比较慢
     *
     * @param nums
     * @return
     */
    private int getMiddlePoint(int[] nums) {
        int leftSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        for(int i = 0 ; i < nums.length; i++){
            if(leftSum * 2 + nums[i] == totalSum){
                System.out.println("index = " + i + " 左边和右边的和 = " + leftSum);
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * 沙比解法
     * 1
     * 1+2
     * 1+2+3 可以重复利用的
     * @param nums
     * @return
     */
    private int getSbPoint(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = calculateSum(0, i, nums);
            int right = calculateSum(i + 1, nums.length, nums);
            if (left == right) {
                System.out.println("index = " + i + " 左边和右边的和 = " + left);
                return i;
            }
        }
        return -1;
    }

    private int calculateSum(int left, int right, int[] nums) {
        int result = 0;
        for (int i = left; i < right; i++) {
            result += nums[i];
        }
        return result;
    }
}
