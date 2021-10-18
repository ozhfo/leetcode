package algorithm.求和;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
// 你可以按任意顺序返回答案。

//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//

//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//

//
//输入：nums = [3,3], target = 6
//输出：[0,1]

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
// Related Topics 数组 哈希表
// 👍 12330 👎 0


import util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * User: sam_zhan
 * DateTime: 2021/10/13 11:48 上午
 */
public class LC_1_两数之和 {

    public static void main(String[] args) {
        LC_1_两数之和 lc = new LC_1_两数之和();
        int[] nums = new int[]{1,3,5,7,9,10,23,17};
        ArrayUtil.printArray(lc.twoSum憨憨(nums,13), "憨憨做法");
        ArrayUtil.printArray(lc.twoSum(nums,13), "Hash做法");
    }

    public int[] twoSum憨憨(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 遍历一次 利用hashMap特性
     * i走过就进去 如果j符合条件那么已存在
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}