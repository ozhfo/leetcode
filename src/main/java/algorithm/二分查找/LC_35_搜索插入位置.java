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

public class LC_35_搜索插入位置 {

    public static void main(String[] args) {
        LC_35_搜索插入位置 lc = new LC_35_搜索插入位置();
        int nums[] = new int[]{1, 3};
        int target = 0;
        System.out.println("数组是 " + JSON.toJSONString(nums));
//        int index = lc.getArrayIndex(0, nums.length, target, nums);
//        int index = lc.searchInsert(nums, target);
        int index = lc.searchInsert2(nums, target);
        System.out.println("target = " + target + " 目标点位置是：" + index);
    }

    /**
     * 左侧版本
     * 0.right = nums.length - 1
     * 1.left < right
     * 2.自己处理边界问题
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
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
        // 从while出来之后的几种情况
        //一种直接return
        //一种在left左边 1 3 5 target = 2 left = 0 return left + 1
        //一种在left的右边 1 3 5 target = 0 left = 0 return left
        return nums[left] < target ? left + 1 : left;
    }

    /**
     * 左侧查找的模板
     * 0.right = nums.length
     * 1.right = mid
     * 这种不需要处理边界问题 因为right不动 只有left+1了 那么就是left
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
                // right不减一
                right = mid;
            } else {
                // 只有小于的时候才会加1
                // 如果没发生加1 那就是当前
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 左侧版本用常规思路来写
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert11(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
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



}
