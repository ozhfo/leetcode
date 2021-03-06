package algorithm.双指针;

import java.util.Arrays;

/**
 * @author zhf
 * DateTime: 2020/11/15 5:06 下午
 */
public class LC_283_移动零 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     **/

    public static void main(String[] args) {
        LC_283_移动零 lc = new LC_283_移动零();
        int[] nums = new int[]{1, 1, 0, 1, 2, 1, 0, 0, 3, 9, 0, 12, 0, 0};
        lc.moveZero0(nums);
        int[] nums1 = new int[]{1, 1, 0, 1, 2, 1, 0, 0, 3, 9, 0, 12, 0, 0};
        lc.moveZero1(nums1);
        int[] nums2 = new int[]{1, 1, 0, 1, 2, 1, 0, 0, 3, 9, 0, 12, 0, 0};
        lc.moveZero2(nums2);
        int[] zz = new int[]{1, 1, 0, 1, 2, 1, 0, 0, 3, 9, 0, 12, 0, 0};
        lc.moveZero3(zz);


    }

    /**
     * best
     *
     * @param nums
     */
    public void moveZero2(int[] nums) {
        // 原数组操作 减少次数
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }


    /**
     * 不是0的全部按照index挪 index之后的置为0
     *
     * @param nums
     */
    private void moveZero0(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 不是0的全部按照index挪 index之后的置为0
     * 优化版本
     *
     * @param nums
     */
    private void moveZero1(int[] nums) {
        // j永远记录下一个非0数据的位置  找到所有的非0数据 都挪到j上面去 没有挪的数据自然就是0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    /**
     * 记录第一个0的位置
     *
     * @param nums
     */
    private void moveZero3(int[] nums) {
        // 只记录第一个0的位置
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (firstZeroIndex == -1 && nums[i] == 0) {
                firstZeroIndex = i;
            } else if (firstZeroIndex != -1 && nums[i] != 0) {
                nums[firstZeroIndex++] = nums[i];
                nums[i] = 0;
            }
        }
    }


}