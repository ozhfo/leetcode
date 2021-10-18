package leetcode;

public class LC_11 {

    /**
     * https://leetcode-cn.com/problems/container-with-most-water
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别
     * (i，ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     */

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
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
