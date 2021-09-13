package algorithm.二分查找;

/**
 * @author zhf
 * @since 2021/3/29 11:21 下午
 **/

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//
// 示例 1:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//
//
// 示例 2:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
//
// 进阶:
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 309 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LC_81 {

    public static void main(String[] args) {
        int [] nums = {7,8,8,9,1,2,4,4,6};
        LC_81 main = new LC_81();
        main.search(nums, 5);
    }

    /**
     * 因为原来是全局有序 现在是两段有序
     * middle点 要么在第一段 要么在第二段不管 怎么样都知道是否有序
     * 6 7 1 2 3 4 5   此时nums[middle] = 2 如果 start > mid 那么后面一半是有序的
     * 3 4 5 6 7 1 2   此时nums[middle] = 6 如果 start < mid 那么前面一半是有序的
     * 1 0 1 1 1       此时nums[middle] = 1 start == middle 分不清楚左边还是右边 start++ 降级为普通遍历
     * left-middle递增  middle+1-right递增
     * 没必要
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        return true;
    }
}

