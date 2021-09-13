package algorithm.二分查找;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
// 请找出其中最小的元素。

// 示例 1：
//输入：nums = [3,4,5,1,2]
//输出：1

// 示例 2：
//输入：nums = [4,5,6,7,0,1,2]
//输出：0


// 示例 3：
//输入：nums = [1]
//输出：1

import com.alibaba.fastjson.JSON;

// 提示：
//
//
// 1 <= nums.length <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数都是 唯一 的
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
//
public class LC_153 {

    public static void main(String[] args) {
        LC_153 lc = new LC_153();
//        int nums[] = new int[]{800,900,1000,1200,2200,3300,3500,0,1,2,3,4,5,6,7,8,9,10, 15,16,17};
        int nums[] = new int[]{4, 5, 6, 7, 8, 1, 2};
//        int nums[] = new int[]{1};
        System.out.println("数组是 " + JSON.toJSONString(nums));
        int minNum = lc.searchMinNum(nums);
        System.out.println("最小值 = " + minNum);
    }

    /**
     * 搜索最小数字
     * 左边的最小值已知
     * 找到右边的最小值
     *
     * @param nums
     * @return
     */
    private int searchMinNum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int target = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left + 1) / 2 + left;
            if (nums[middle] > target) {
                // 4 5 6 1 2
                left = middle + 1;
            } else if (nums[middle] < target) {
                // 说明走进了第二个序列 最小值一定在middle的左边
                right = middle - 1;
                target = nums[middle];
            }
        }
        return target;
    }


    public int findMin(int[] nums) {
        // 2 1
        // 1
        // 3 4 5 1 2
        // 7 8 9 1 2 3 4 5 6 7
        int left = 0;
        int right = nums.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            }
        }
        return nums[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
    }


}
