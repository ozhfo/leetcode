package algorithm.滑动窗口;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 

// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。

// 
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0

// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 

// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 788 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LC_209_长度最小的子数组 {
    public static void main(String[] args) {
        LC_209_长度最小的子数组 lc = new LC_209_长度最小的子数组();
        int[] nums = new int[]{10,2,3};
        // 题目条件是>=
        System.out.println(lc.minSubArrayLen(6, nums));
        System.out.println(lc.minSubArrayLen1(6, nums));
        System.out.println(lc.minSubArrayLen2(6, nums));
        System.out.println(lc.minSubArrayLen3(6, nums));
    }

    /**
     * 前缀和+二分
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int preSum[] = new int[nums.length];
        // 第一轮计算的时候也判断一下
        int minLength = preSum.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
            } else {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            // 判断是否满足target
            if (preSum[i] >= target) {
                minLength = Math.min(minLength,i + 1);
            }
        }
        // 处理前缀和数组 因为原数组是正整数 所以preSum变成了一个单调递增的数组

        for (int current = 1; current < preSum.length; current++) {
            int left = current, right = preSum.length - 1;
            while (left <= right) {
                // 3 4 -> middle = 3 left = middle + 1 -> preSum[4]=7
                int diff = preSum[current - 1];
                int middle = left + (right - left) / 2;
                // 1 2 3 4 5 假设1的前缀和和2的前缀和都没有那么在处理3的时候去掉2的前缀和
                if (preSum[middle] - diff < target) {
                    left = middle + 1;
                } else {
                    /** 只要大于等于就满足条件 **/
                    right = middle - 1;
                    minLength = Math.min(minLength,middle - current + 1);
                }
            }
        }
        return minLength == preSum.length+1 ? 0 : minLength;
    }

    /**
     * 暴力
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 前缀和+二分
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
