package algorithm.二分查找;

import java.util.Arrays;

public class LC_34 {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]

     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,22,33,42,56,56,56,56,56,67,88,89,93,97,100,101};
        int target = 56;
        int[] index = getIndexZHF(nums,target,0,nums.length - 1);
        Arrays.stream(index).forEach(x -> System.out.print(x +  " "));
        int[] index2 = searchRange(nums,target);
        Arrays.stream(index2).forEach(x -> System.out.print(x +  " "));
    }


    /**
     * 官方题解
     */
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length
                && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    /**
     * 太low了
     * for循环和递归
     * 递归条件放在哪里
     * 二分查找
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int[] getIndexZHF(int[] nums, int target, int left, int right) {
        /** 结束条件 left right 指针重合 **/
        while (left <= right) {
            int middle = (right + left) / 2;
            if (target > nums[middle]) {
                /** 值在右边 移动左指针 **/
                left = middle + 1;
            } else if (target < nums[middle]) {
                /** 值在左边 移动右指针 **/
                right = middle -1;
            } else {
                /** 找到了一个值 但是可能的数据是 left = 6, 7, 7, middle = 7, 7, 8, right = 9
                 * 所以需要继续遍历这个left和right 找到最左left和最右right**/
                if (nums[left] != target) {
                    // 因为left不是target需要向右移动
                    left = getIndexZHF(nums,target, left + 1, middle )[0];
                }
                if (nums[right] != target) {
                    right = getIndexZHF(nums, target, middle, right - 1)[1];
                }
                return new int[] {left, right};
            }
        }
        return new int[]{-1,-1};
    }





}
