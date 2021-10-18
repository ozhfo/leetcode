package algorithm.二分查找;

//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
//

//
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//

//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//

//
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers 按 非递减顺序 排列
// -1000 <= target <= 1000
// 仅存在一个有效答案
//
// Related Topics 数组 双指针 二分查找
// 👍 595 👎 0


import util.ArrayUtil;

/**
 * User: sam_zhan
 * DateTime: 2021/10/9 4:36 下午
 */
public class LC_167_两数之和2 {

    public static void main(String[] args) {
        LC_167_两数之和2 lc = new LC_167_两数之和2();
        int nums[] = {2,7,11,15};
        ArrayUtil.printArray(lc.twoSum(nums,9),"xxx");
        ArrayUtil.printArray(lc.twoSum2(nums,9),"xxx");
    }

    /**
     * 双指针+二分
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // left固定 right变成二分查找
        for(int i = 0; i < numbers.length - 1; i ++){
           int trueTarget = target - numbers[i];
           int right = searchTarget(numbers,i+1, trueTarget);
           if(right != -1){
               return new int[]{i + 1, right + 1};
           }
        }
        return new int[]{-1, -1};
    }

    public int searchTarget(int[] numbers, int left, int target){
        int right = numbers.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(numbers[middle] < target){
                left = middle + 1;
            }else if(numbers[middle] > target){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 双指针+2分
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int middle = (i + j) >>> 1;
            if (numbers[i] + numbers[middle] > target) {
                j = middle - 1;
            } else if (numbers[middle] + numbers[j] < target) {
                i = middle + 1;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 1 2 3 4 5 target = 7
     * left = 0 <= i < j <= right = numbers.length - 1
     * 由于有确定的唯一解 那么left左移动 right右移动的时候 不可能错过目标
     * 因为是唯一解 那么left到了i之后 不可能动 如果会动 那么说明不是唯一解
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        // 数组是递增的
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left ++;
            }else if(sum > target){
                right --;
            }else{
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}


