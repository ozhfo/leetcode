package algorithm.sildewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: sam_zhan
 * DateTime: 2020/10/9 5:41 下午
 */
public class slideWindow_2 {

    /**
     * 第239题：给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
     * 滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
     * [1,2,5,8,2,7,6,-2,4,5] k=3 结果=[5,8,8,7,7,6,5]
     */

    public static void main(String[] args) {
        Integer num[] = {1,2,5,8,2,7,6,-2,4,5};
        int windowSize = 3;
        version1(num,windowSize);
    }

    private static void version1(Integer[] num, int windowSize) {
        List<Integer> list = Arrays.asList(num);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i + windowSize <= list.size(); i++){
            List<Integer> tempList = list.subList(i, i + windowSize);
            Integer max = tempList.stream().max(Integer::compareTo).get();
            result.add(max);
        }
        System.out.println(result);
    }

}