package algorithm.双指针;

import util.ArrayUtil;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
// 进阶：
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//向右旋转 4 步: [4,5,6,7,1,2,3]
//向右旋转 5 步: [3,4,5,6,7,1,2]


//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 1 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105

//
// Related Topics 数组 数学 双指针
// 👍 1151 👎 0


/**
 * User: sam_zhan
 * DateTime: 2021/10/9 3:15 下午
 */
public class LC_189_旋转数组 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        LC_189_旋转数组 lc = new LC_189_旋转数组();
//        ArrayUtil.printArray(lc.rotate(nums, 5), "双指针");
        ArrayUtil.printArray(lc.rotate2(nums, 1), "暴力");
    }

    /**
     * 递归超时
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0){
            // 停止递归
            return nums;
        }
        // 否则去下一层
        rotate(nums, k - 1);
        // 本层结束之后 移动1
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
        return nums;
    }

    /**
     * 使用额外数组
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate2(int[] nums, int k){
        // 暴力做出来
        int length = nums.length;
        k = k % length;
        int[] result = new int[nums.length];
        //前置部分
        for(int i = 0; i < k; i ++){
            result[i] = nums[length - k + i];
        }
        // 后半部分
        for(int i = 0; i < length - k; i++){
            result[k+i] = nums[i];
        }
        return result;
    }

    /**
     * 使用额外数组
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * O(1)原地交换
     * @param nums
     * @param k
     */
    public void rotate6(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    /**
     * 一起翻
     *
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }


}