package dsaa.数组;


// 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素

import util.ArrayUtil;

public class LC_002 {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                {1,2,3,4,5},
                {5,6,7,8,9},
                {10,11,12,13,14},
                {15,16,17,18,19},
        };
//        int[][] intervals = new int[][]{
//                {1,2,3,4,5},
//                {5,6,7,8,9},
//                {10,11,12,13,14},
//                {15,16,17,18,19},
//                {20,21,22,23,24}
//        };
        LC_002 lc = new LC_002();
        ArrayUtil.printDoubleArray("start", intervals);
        int[] res = lc.diagonalTraverse(intervals);
        ArrayUtil.printDoubleArray("end", intervals);
        ArrayUtil.printArray(res,"呵呵");
    }


    /**
     * 对角线遍历
     * @param intervals
     * @return
     */
    public int[] diagonalTraverse(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0];
        }
        int row = intervals.length;
        int column = intervals[0].length;

        int [] res = new int[row * column];
        int resIndex = 0;
        int rowIndex = 0; int columnIndex = 0;
        for(int i = 0; i < row + column; i ++){
            // 和为0
            while(rowIndex < row && columnIndex < column && (rowIndex + columnIndex == i)){
                    // 00
                    // 01 10
                    // 20 11 02
                    // 03 12 21 30
                    // 40 31 22 13 04
                    // 14 23 32 41
                    // 42 33 24
                    // 34 43
                    // 44
                    if(i % 2 == 0){
                        for(; rowIndex >= 0; rowIndex --){
                            if(i - rowIndex == column){
                                break;
                            }
                            columnIndex = i - rowIndex;
                            res[resIndex++] = intervals[rowIndex][columnIndex];
                        }
                        // 恢复0
                        rowIndex ++;
                        // 这里不能无限加
                        if(columnIndex + 1 == column){
                            rowIndex ++;
                        }else{
                            columnIndex ++;
                        }
                    }else{
                        for(; rowIndex <= i && rowIndex < row; rowIndex ++){
                            columnIndex = i - rowIndex;
                            res[resIndex++] = intervals[rowIndex][columnIndex];
                        }
                        if(rowIndex == row){
                            rowIndex --;
                            columnIndex ++;
                        }
                    }
                }
        }
        return res;
    }

}
