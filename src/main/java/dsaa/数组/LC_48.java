package dsaa.数组;


//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
//
//        不占用额外内存空间能否做到？
//
//        示例 1:
//
//        给定 matrix =
//        [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//
//        原地旋转输入矩阵，使其变为:
//        [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//        ]
//        示例 2:
//
//        给定 matrix =
//        [
//        [ 5, 1, 9,11],
//        [ 2, 4, 8,10],
//        [13, 3, 6, 7],
//        [15,14,12,16]
//        ],
//
//        原地旋转输入矩阵，使其变为:
//        [
//        [15,13, 2, 5],
//        [14, 3, 4, 1],
//        [12, 6, 8, 9],
//        [16, 7,10,11]
//        ]

import util.ArrayUtil;

public class LC_48 {

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };

//        int[][] intervals = new int[][]{
//                {1, 2,},
//                {3, 4},
//        };

        int[][] intervals = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

//        int[][] intervals = new int[][]{
//                {1,2,3} ,
//                {4,5,6},
//                {7,8,9}
//        };
        LC_48 lc = new LC_48();
        ArrayUtil.printDoubleArray("start", intervals);
        int[][] res = lc.rotateNum(intervals);
        ArrayUtil.printDoubleArray("end", intervals);
    }

    /**
     * 二维数组翻转
     *
     * @param intervals
     * @return
     */
    private int[][] rotateNum(int[][] intervals) {
        int n = intervals.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = intervals[i][j];
                intervals[i][j] = intervals[n - 1 - j][i];
                intervals[n - 1 - j][i] = intervals[n - 1 - i][n - 1 - j];
                intervals[n - 1 - i][n - 1 - j] = intervals[j][n - 1 - i];
                intervals[j][n - 1 - i] = temp;
            }
        }
        return intervals;
    }

    /**
     * 官方版本原地旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


}
