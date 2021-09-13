package leetcode;

/**
 * TODO
 *
 * @author zhf
 * DateTime: 2020/11/15 9:25 下午
 */
public class LC_49 {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        containerWithMostWater(nums);
    }

    // 8 1 2 3 4 5 6 8  min(left,right) * t;
    // 取决于最小的那个高度 3 8 = 3 * length
    // 改变3  可能是(4,5,6,7) * (length - x)可能变大
    // 改变8  没有任何意义 还是3 * (length - x)
    public static void containerWithMostWater(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(nums[left], nums[right]);
            int tempArea = minHeight * (right - left);
            maxArea = Math.max(tempArea, maxArea);
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("maxArea = " + maxArea);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }



}

