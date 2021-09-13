package algorithm.二分查找;


//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
//
//示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。

import com.alibaba.fastjson.JSON;

public class LC_704 {

    public static void main(String[] args) {
        LC_704 lc = new LC_704();
        int nums[] = new int[]{-1,0,3,5,9,12};
        int target = 6;
        System.out.println("数组是 " + JSON.toJSONString(nums));
        int index = lc.searchNum(nums, target,0, nums.length -1);
        System.out.println("target = " + target + " 目标点位置是：" + index);
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 递归版本
     */
    private int searchNum(int nums[], int target, int left, int right){
        int middle = left + (right - left) / 2;
        if(left > right){
            return -1;
        }
        if(nums[middle] > target){
          return   searchNum(nums, target, left, middle -1);
        }else if(nums[middle] < target){
          return   searchNum(nums, target, middle + 1, right);
        }else{
            return middle;
        }
    }
}


