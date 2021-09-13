package leetcode.done;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhf
 * DateTime: 2020/11/15 5:06 下午
 */
public class LC_283 {

    /**给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:

    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
    说明:

    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。**/

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,2,1,0,0,3,9,0,12,0,0};
        // [1,1,1,2,1,3,9,12,0,0,0,0,0,0]
        moveZeroLogIndex(nums);
        int[] nums1 = new int[]{1,1,0,1,2,1,0,0,3,9,0,12,0,0};
        moveZeroLogIndex2(nums1);
        int[] nums2 = new int[]{1,1,0,1,2,1,0,0,3,9,0,12,0,0};
        moveZeroLogZero(nums2);


    }

    /**
     * 不是0的全部按照index挪 index之后的置为0
     * @param nums
     */
    private static void moveZeroLogIndex(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index ++] = nums[i];
            }
        }
        while(index<nums.length){
            nums[index++] = 0;
        }
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("    moveZero4");
    }

    /**
     * 不是0的全部按照index挪 index之后的置为0
     * 优化版本
     * @param nums
     */
    private static void moveZeroLogIndex2(int[] nums) {
        // j永远记录下一个非0数据的位置  找到所有的非0数据 都挪到j上面去 没有挪的数据自然就是0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(j != i){
                    nums[i] = 0;
                }
                j++;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("    moveZero");
    }

    /**
     * 记录第一个0的位置
     * @param nums
     */
    private static void moveZeroLogZero(int[] nums) {
        // 只记录第一个0的位置
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (firstZeroIndex == -1 && nums[i] == 0) {
                firstZeroIndex = i;
            } else if (firstZeroIndex != -1 && nums[i] != 0) {
                nums[firstZeroIndex] = nums[i];
                nums[i] = 0;
                /** 关键 **/
                firstZeroIndex++;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("   moveZero2");
    }






}