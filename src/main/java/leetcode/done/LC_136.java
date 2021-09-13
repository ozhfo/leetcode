package leetcode.done;

import java.util.*;

//给定一个非空 整数 数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1675 👎 0


public class LC_136 {

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数于0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     * 2^3^1^4^3^2^1 = 2^2^3^3^1^1^4 = 0^0^0^4 = 4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b)->a^b).getAsInt();
    }




    public static void main(String[] args) {
        int nums[] = new int[]{2,3,1,4,3,2,1,5,6,7,6,5,7};
        LC_136 solution = new LC_136();
        System.out.println("异或算法：符合要求" + solution.singleNumber(nums));
//        System.out.println("借助数组：放入删除" + solution.singleNumber1(nums));
        System.out.println("排序再比较：最简" + solution.singleNumber2(nums));
        System.out.println("hash计算次数：常规" + solution.singleNumber3(nums));
        System.out.println("计算一次的双倍-目前的合：根据题意" + solution.singleNumber4(nums));
    }

    /**
     * 如果不考虑时间和空间复杂度的解法
     * 1.遍历放入list 如果没有那么放进去 如果已存在那么删掉那个 最后剩下的就是
     */
    private Integer singleNumber1(int[] nums) {
        // TODO
        return 0;
    }


    /**
     * 2.先排序再遍历是最快的 只要时间 不要空间 因为相邻找到了就直接指针+2
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i + 1 < nums.length; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 3.hash记录每个出现的次数 为1次的就是
     * @param nums
     * @return
     */
    private Integer singleNumber3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry entry : map.entrySet()){
            if((Integer)entry.getValue() == 1){
                return (Integer)entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 4.由于都是只出现2次 那么(a+b+c)*2 -所有的和 那么就是多出来的那个
     * @param nums
     * @return
     */
    private Integer singleNumber4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(x -> set.add(x));
        return set.stream().mapToInt(x -> x).sum() * 2 - Arrays.stream(nums).sum();
    }





}
