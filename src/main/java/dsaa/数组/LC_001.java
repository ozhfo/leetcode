package dsaa.数组;


//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//        示例 1：
//
//        输入：
//        [
//        [1,1,1],
//        [1,0,1],
//        [1,1,1]
//        ]
//        输出：
//        [
//        [1,0,1],
//        [0,0,0],
//        [1,0,1]
//        ]
//        示例 2：
//
//        输入：
//        [
//        [0,1,2,0],
//        [3,4,5,2],
//        [1,3,1,5]
//        ]
//        输出：
//        [
//        [0,0,0,0],
//        [0,4,5,0],
//        [0,3,1,0]
//        ]

import util.ArrayUtil;

public class LC_001 {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        LC_001 lc = new LC_001();
        ArrayUtil.printDoubleArray("start", intervals);
        int[][] res = lc.setZero(intervals);
        ArrayUtil.printDoubleArray("end", intervals);
    }



    /**
     * 二维数组清0
     * 标记为0的行列
     * @param intervals
     * @return
     */
    private int[][] setZero(int[][] intervals) {
        int[] row = new int[intervals.length];
        int[] column = new int[intervals[0].length];

        // mark zero
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                if(intervals[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        setZeroColumn(row,  intervals, 0);
        setZeroColumn(column,  intervals, 1);
        return intervals;
    }

    /**
     * 给行列设置0
     * @param column
     * @param intervals
     * @param type
     */
    private void setZeroColumn(int column[],  int intervals[][], int type){
        int rowLength = intervals.length;
        int columnLength = intervals[0].length;
        for(int i = 0; i < column.length; i ++){
            if(column[i] == 1){
                int length = rowLength;
                if(type == 0){
                     length = columnLength;
                }
                for(int j = 0; j < length; j ++){
                    if(type == 0){
                        intervals[i][j] = 0;
                    }else{
                        intervals[j][i] = 0;
                    }
                }
            }
        }
    }

}
