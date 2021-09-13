package dsaa.数组;

import util.ArrayUtil;
import util.PrintUtil;

/**

 *
 * @author zhf
 * DateTime: 2020/11/15 6:29 下午
 */
public class LC_26 {

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。

     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public static void main(String[] args) {
        LC_26 lc = new LC_26();
        int []nums = ArrayUtil.getSortedRepeatArray();
        lc.distinctArrayDSB(nums);
        int []num1 = ArrayUtil.getSortedRepeatArray();
        lc.removeDuplicatesFromSortedArray(num1);
        /** 5个月之后重写 **/
        int[] nums_5month = ArrayUtil.getSortedRepeatArray();
        ArrayUtil.printArray(nums_5month, "begin");
        lc.removeDuplicates(nums);

    }




    /**
     * 0,0,1,1,1,2,2,3,3,4
     * 0-11-1-12-13-14
     * 0 -1 1 -1 2 -1 3 -1
     *
     * @param nums
     */
    private void distinctArrayDSB(int[] nums) {
        // 所有的重复多余的置为min
        int min = nums[0] - 1;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j] && nums[i] != min){
                    nums[j] = min;
                }else{
                    break;
                }
            }
        }
        ArrayUtil.printArray(nums,"mark");
        // 所有不是min的前移
        filterArrayTarget(nums,min);
        ArrayUtil.printArray(nums,"distinctArray");
    }

    /**
     * 去除X 并保证原数组相对有序
     *
     * @param nums
     */
    public static void filterArrayTarget(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = target;
        }
        ArrayUtil.printArray(nums,"filterArrayTarget");
    }


    /**
     * {1,2,2,2,3,3,4,4,5,6,7,8}
     * {0,1,2,3,4,5}
     * {1,1,2,3,3,3,6,7,9}
     * @param nums
     */
    private void removeDuplicatesFromSortedArray(int[] nums){
        int slow = 0;
        for (int j = slow + 1; j < nums.length; j++){
            if(nums[j] != nums[slow]){
                nums[++slow] = nums[j];
            }
        }
        ArrayUtil.printArray(nums,"removeDuplicatesFromSortedArray");
    }



    /**
     * 利用数组有序的特点来处理
     * 双指针
     * 一个指向当前
     * 一个指向未来
     * @param nums [0,1,1,1,2,3,3,3,4,4,5,6]
     * @return
     */
    public int removeDuplicates(int[] nums) {
        PrintUtil.bigPrintln("开始");
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
        }
        ArrayUtil.printArray(nums,"去重的数组");
        System.out.println("长度" + slow + 1);
        return slow + 1;
    }

}