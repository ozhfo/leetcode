package algorithm.二分查找;
//符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
//
//
// arr.length >= 3
// 存在 i（0 < i < arr.length - 1）使得：
//
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//

// 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i +
//1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
//

//
//输入：arr = [0,1,0]
//输出：1

//输入：arr = [1,3,5,4,2]
//输出：2
//

//输入：arr = [0,10,5,2]
//输出：1

//
//输入：arr = [3,4,5,1]
//输出：2

//
//输入：arr = [24,69,100,99,79,78,67,36,26,19]
//输出：2

//
// 3 <= arr.length <= 104
// 0 <= arr[i] <= 106
// 题目数据保证 arr 是一个山脉数组

// 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？

// 注意：本题与主站 852 题相同：https://leetcode-cn.com/problems/peak-index-in-a-mountain-ar
//ray/
// Related Topics 数组 二分查找
// 👍 40 👎 0
/**
 * User: sam_zhan
 * DateTime: 2021/10/14 3:54 下午
 */
public class JZ_069_山峰数组的顶部 {

    public static void main(String[] args) {
        JZ_069_山峰数组的顶部 jz = new JZ_069_山峰数组的顶部();
        int []nums = new int[]{24,69,100,99,79,78,67,36,26,19};
        System.out.println(jz.peakIndexInMountainArray(nums));
    }

    /**
     * 1 4 5 4 3 2 1
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0,  right = arr.length - 1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(arr[middle] < arr[middle + 1]){
                // 顶部在右边
                left = middle + 1;
            }else{
                // 顶部在左边
                right = middle;
            }
        }
        return left;
    }
}