package dsaa.数组;


//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//         
//
//        说明:
//
//        为什么返回数值是整数，但输出的答案是数组呢?
//
//        请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
//        你可以想象内部操作如下:
//
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//        int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//        for (int i = 0; i < len; i++) {
//            print(nums[i]);
//        }
//         
//
//        示例 1：
//
//        输入：nums = [3,2,2,3], val = 3
//        输出：2, nums = [2,2]
//        解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//        示例 2：
//
//        输入：nums = [0,1,2,2,3,0,4,2], val = 2
//        输出：5, nums = [0,1,4,0,3]
//        解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
//         
//
//        提示：
//
//        0 <= nums.length <= 100
//        0 <= nums[i] <= 50
//        0 <= val <= 100


import util.ArrayUtil;
import util.PrintUtil;

/**
 * @author zhf
 * @since 2021/4/20 11:51 下午
 **/
public class LC_27 {


    public static void main(String[] args) {
//        int nums[] = new int[]{0,1,2,2,3,0,4,2};
        int nums[] = new int[]{2,2,3};
        ArrayUtil.printArray(nums, "begin");
        LC_27 lc = new LC_27();
        int target = 2;
        lc.removeDesignatedNumDSB(nums, target);
    }

    /**
     * 沙币的首尾指针
     */
    public int removeDesignatedNumDSB(int[] nums, int target) {
        PrintUtil.bigPrintln("开始");
        if(nums.length == 0){
            return 0;
        }
        int targetIndex = nums.length - 1;
        int i = 0;
        boolean flag = false;
        for (; i <= targetIndex; i++) {
            // 跳过正确值
            if (nums[i] != target) {
                flag = true;
                continue;
            }
            // 找正确值（可能有 可能没有）
            while (targetIndex > 0 && nums[targetIndex] == target) {
                targetIndex--;
            }
            if (i < targetIndex) {
                // 成功找到
                flag = true;
                nums[i] = nums[targetIndex--];
            } else {
                // 找不到
                flag = false;
            }
        }
        System.out.println("targetIndex = " + (flag ? i : i - 1));
        ArrayUtil.printArray(nums, "乱杀");
        return flag ? i + 1 : i;
    }

    /**
     * 真正的首尾指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                // 只有成功才++
                left++;
            }
        }
        return left;
    }


    /**
     * 双指针
     * i正常遍历
     * left存正常值 只要不是target就存起来 left长度就是最后长度
     * @param nums
     * @param target
     * @return
     */
    public int removeDesignatedNum(int[] nums, int target){
        int left = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != target){
                nums[left ++] = nums[i];
            }
        }
        return left;
    }

    /**
     * [... validRange]: 有效区
     * (validRange ... index): 垃圾区
     * [index ... ]: 未知区
     * @param nums
     * @param val
     * @return
     */
    public int removeElement22(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return n;

        int validRange = -1;
        int index = 0;
        while (index < n) {
            if (nums[index] != val) {
                // 发货到有效区
                nums[++validRange] = nums[index];
            }
            index++;
        }

        return validRange + 1;
    }



    /**
     * 假设需要保证原数组的顺序怎么做？
     */
    public int removeDesignatedNumSorted(int[] nums, int target) {
        PrintUtil.bigPrintln("开始");
        int targetIndex = nums.length - 1;
        for (int i = 0; i <= targetIndex; i++) {
            while (nums[targetIndex] == target) {
                targetIndex--;
            }
            if (nums[i] == target) {
                nums[i] = nums[targetIndex--];
            }
        }
        System.out.println("targetIndex = " + targetIndex);
        ArrayUtil.printArray(nums, "乱杀");
        return targetIndex;
    }

}
