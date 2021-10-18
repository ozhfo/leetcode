package algorithm.双指针;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：

//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 已按 非递减顺序 排序

// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序
// 👍 317 👎 0


import util.ArrayUtil;

public class LC_977_有序数组的平方 {

    public static void main(String[] args) {
        LC_977_有序数组的平方 lc = new LC_977_有序数组的平方();
        int[] nums = {-7,-3,2,3,11};
        ArrayUtil.printArray(lc.sortedSquares(nums),"xx");
    }


    /**
     *      1.递增
     *      2.计算平方之后仍然保持递增
     *      3.时间O(n)
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        // 双指针 从两边开始找 距离0越远就越大
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = right;
        while(left <= right){
            int temp = left;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                temp = right;
                right --;
            }else{
                left ++;
            }
            result[index--] = nums[temp] * nums[temp];
        }
        return result;
    }
}
