package dsaa.数组;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

//        进阶：
//
//        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
//        你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//         
//
//        示例 1:
//
//        输入: nums = [1,2,3,4,5,6,7], k = 3
//        输出: [5,6,7,1,2,3,4]
//        解释:
//        向右旋转 1 步: [7,1,2,3,4,5,6]
//        向右旋转 2 步: [6,7,1,2,3,4,5]
//        向右旋转 3 步: [5,6,7,1,2,3,4]
//        示例 2:
//
//        输入：nums = [-1,-100,3,99], k = 2
//        输出：[3,99,-1,-100]
//        解释:
//        向右旋转 1 步: [99,-1,-100,3]
//        向右旋转 2 步: [3,99,-1,-100]
//         
//
//        提示：
//
//        1 <= nums.length <= 2 * 104
//        -231 <= nums[i] <= 231 - 1
//        0 <= k <= 105

import util.ArrayUtil;

/**
 * @author zhf
 * @since 2021/5/3 8:04 下午
 **/
public class LC_旋转数组 {

    public static void main(String[] args) {
        LC_旋转数组 lc = new LC_旋转数组();
//        int nums[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int nums[] = new int[]{-1};
//        int nums[] = new int[]{-1,-100,3,99};
        lc.rotate(nums, 2);
        ArrayUtil.printArray(nums, "递归");

    }

    /**
     * 递归
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 超过数组长度的取模
        if (k == 0 || k == nums.length) { // 次数为0或者数组长度 都是数组本身
            return;
        }
        rotate(nums, k - 1); // 每次移动一位
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    /**
     * 循环
     * @param nums
     * @param k
     */
    public void rotate2(int []nums, int k){
        if (k == 0 || k == nums.length) { // 次数为0或者数组长度 都是数组本身
            return;
        }
    }
}
