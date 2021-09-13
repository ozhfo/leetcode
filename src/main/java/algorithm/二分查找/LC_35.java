package algorithm.二分查找;


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        你可以假设数组中无重复元素。
//
//        示例 1:
//
//        输入: [1,3,5,6], 5
//        输出: 2
//        示例 2:
//
//        输入: [1,3,5,6], 2
//        输出: 1
//        示例 3:
//
//        输入: [1,3,5,6], 7
//        输出: 4
//        示例 4:
//
//        输入: [1,3,5,6], 0
//        输出: 0

import com.alibaba.fastjson.JSON;

public class LC_35 {

    public static void main(String[] args) {
        LC_35 lc = new LC_35();
        int nums[] = new int[]{1, 3};
        int target = 0;
        System.out.println("数组是 " + JSON.toJSONString(nums));
//        int index = lc.getArrayIndex(0, nums.length, target, nums);
//        int index = lc.searchInsert(nums, target);
        int index = lc.searchInsert2(nums, target);
        System.out.println("target = " + target + " 目标点位置是：" + index);
    }

    /**
     * 二分查找
     * [1,3] 0
     * 测试边界
     * 考虑往最左插入、最右插入、最左相等、最右相等、中间插入、中间相等
     * right = mid - 1 可能为负数 mid = 0
     * left = mid + 1 会不会超过数组界限呢
     * 最外层限定了 left < right
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }

    public int searchInsert11(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;

    }

    /**
     * right = mid 不做减一处理
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
