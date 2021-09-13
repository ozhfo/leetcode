package dsaa.数组;


//给出一个区间的集合，请合并所有重叠的区间。
//
//         
//
//        示例 1:
//
//        输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出: [[1,6],[8,10],[15,18]]
//        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2:
//
//        输入: intervals = [[1,4],[4,5]]
//        输出: [[1,5]]
//        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//        注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//         
//
//        提示：
//        intervals[i][0] <= intervals[i][1]

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Comparator;

public class LC_56 {

    public static void main(String[] args) {
        int intervals[][] = new int[][]{{1, 3}, {0,2}, {4,7},{4, 9}, {11,13},{10, 12}, {2, 5}, {19,20},{1000,1100}, {900,12000},
                {14, 15},{-1,0}, {-9999, -888}};
        LC_56 lc = new LC_56();
        // 不排序 双重循环处理
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("开始");
        int[][] res = lc.myIntersection(intervals);
        stopWatch.stop();
        System.out.println("最终结果：" + JSON.toJSONString(res) + "耗时：" + stopWatch.getLastTaskTimeMillis());

        // 官方推荐 排序处理
        stopWatch.start();
        int[][] res2 = lc.sortIntersection(intervals);
        stopWatch.stop();
        System.out.println("最终结果：" + JSON.toJSONString(res2) + "耗时：" + stopWatch.getLastTaskTimeMillis());

    }

    /**
     * 排序处理的话
     * @param intervals
     * @return
     */
    private int[][] sortIntersection(int[][] intervals){
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，说明不重叠。
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    /**
     * 1.标记可以合并的两个数组a.b
     * 2.合并然后替换b为ba 干掉a
     * 3.如果c可以合并同样 干掉c 替换ba为cba
     * 4.最终没有被干掉的拉出来就是结果
     * @param intervals
     * @return
     */
    private int[][] myIntersection(int[][] intervals){
        int[] mark = new int[intervals.length];
        int count = intervals.length;
        for(int i = 0; i < intervals.length; i++){
            int[] tempi = intervals[i];
            for(int j = i + 1; j < intervals.length && mark[j] == 0; j++){
                // i和j 重合
                if (ifIntersection(tempi, intervals[j])) {
                    // i和j重合 合并i和j赋值给i
                    tempi = mergeArea(tempi, intervals[j]);
                    intervals[j] = tempi;
                    mark[i] = 1;
                    count = intervals.length - 1;
                    break;
                }
            }
        }
        int[][] result = new int[count][2];
        int j = 0;
        for(int i = 0; i < mark.length; i++){
            if(mark[i] == 0){
                System.out.println("有效的结果" + JSON.toJSONString(intervals[i]));
                result[j++] = intervals[i];
            }
        }
        return Arrays.copyOf(result, j);
    }



    /**
     * 判断是否重合
     * @param a
     * @param b
     * @return
     */
    private boolean ifIntersection(int[] a, int[] b) {
        return (a[0] >= b[0] && a[0] <= b[1]) ||
                (a[1] >= b[0] && a[1] <= b[0]) ||
                (b[0] >= a[0] && b[0] <= a[1]) ||
                (b[1] >= a[0] && b[1] <= a[0]);
    }

    /**
     * 合并区间
     *
     * @param
     * @return
     */
    private int[] mergeArea(int[] a, int[] b) {
        int minLeft = a[0] > b[0] ? b[0] : a[0];
        int maxRight = a[1] > b[1] ? a[1] : b[1];
        return new int[]{minLeft, maxRight};
    }

}
