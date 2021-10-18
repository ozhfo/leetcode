package leetcode;

import java.util.*;

/**
 * <p>
 * User: zhf
 * DateTime: 2020/10/29 12:00 上午
 */
public class LC_1207 {

    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     */

    public static void main(String[] args) {
//       int[]arr = {1,2,2,1,1,3};
       int[]arr = {1,2};
//       int[]arr = {1,2,2,1,1,3};
       LC_1207 zz = new LC_1207();
        System.out.println(zz.uniqueOccurrencesDSB(arr));
    }
    public boolean uniqueOccurrencesDSB(int[] arr) {
        Map<Integer,Integer> numCodeMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            numCodeMap.put(arr[i], numCodeMap.getOrDefault(arr[i],0) +  1);
//            Integer count = numCodeMap.get(arr[i]);
//            numCodeMap.put(arr[i], count == null ? 1: count +1);
        }
        List<Integer> countList = new ArrayList<>(numCodeMap.values());
        int firstCount = countList.size();
//        if(firstCount == countList.stream().distinct().count()){
//            return true;
//        }
//        return false;
        // 改进 为什么不一开始就用set呢
//        return firstCount == countList.stream().distinct().count();
        return numCodeMap.size() == new HashSet<>(numCodeMap.values()).size();
    }


    public boolean version2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }

}