package algorithm.滑动窗口;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sam_zhan
 * DateTime: 2020/10/9 10:26 上午
 */
public class slideWindow_1 {

    /** 1-n 找到里面的连续数组 **/

    public static void main(String[] args) {
        version1(150);
        version2(150);
    }

    /**
     * 循环处理方法
     *
     * @param n
     */
    public static void version1(Integer n) {
        List<int[]> list = new ArrayList<>();
        int middle = n / 2 + 1;
        for (int i = 1; i < middle; i++) {
            int result = i;
            for (int j = i + 1; j < n; j++) {
                result += j;
                if (result > n) {
                    break;
                } else if (result == n) {
                    int[] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k - i] = k;
                    }
                    list.add(temp);
                }
            }
        }
        list.stream().forEach(x -> System.out.println(JSON.toJSONString(x)));
    }

    /**
     * 滑动窗口 双指针
     */
    public static void version2(Integer n) {
        List<Integer[]> list = new ArrayList<>();
        int middle = n / 2 + 1;
        int left = 1;
        int right = 1;
        int result = 0;
        while (left < middle) {
            while(result < n){
                result += right;
                right ++;
            }
            if (result == n) {
                Integer[] temp = new Integer[right - left];
                for (int k = left; k < right; k++) {
                    temp[k - left] = k;
                }
                list.add(temp);
            }
            result -= left;
            left ++;
        }
        list.stream().forEach(x -> System.out.println(JSON.toJSONString(x)));
    }

}