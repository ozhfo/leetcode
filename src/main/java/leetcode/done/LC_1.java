package leetcode.done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: zhf
 * DateTime: 2020/10/29 12:22 上午
 */
public class LC_1 {

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static void main(String[] args) {
        LC_1 lc_1 = new LC_1();
        int[] nums = {1,2,3,4,5,6};
        int target = 10;
        Arrays.stream((lc_1.twoSum(nums,target))).asLongStream().forEach(System.out::print);

    }


    public int[] 憨批(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}