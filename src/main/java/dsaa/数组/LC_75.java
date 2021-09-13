package dsaa.数组;
//
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//        示例 1：
//
//        输入：nums = [2,0,2,1,1,0]
//        输出：[0,0,1,1,2,2]
//        示例 2：
//
//        输入：nums = [2,0,1]
//        输出：[0,1,2]
//        示例 3：
//
//        输入：nums = [0]
//        输出：[0]
//        示例 4：
//
//        输入：nums = [1]
//        输出：[1]


import util.ArrayUtil;

/**
 * @author zhf
 * @since 2021/4/13 11:49 下午
 **/
public class LC_75 {



// input  [1,1,0,0,0,0,0,2,2,2,0,0,1]
// output [0,0,0,0,0,0,0,1,1,1,2,2,2]

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,0,0,0,0,0,2,2,2,0,0,1};
        LC_75 lc = new LC_75();
        ArrayUtil.printArray(nums, "start");
        lc.sortColors(nums);
        ArrayUtil.printArray(nums, "end");
    }

    /**
     * 遍历for
     * 交换
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int twoCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroCount ++;
            if(nums[i] == 2) twoCount ++;
        }
        System.out.println("zeroCount = " + zeroCount);
        System.out.println("twoCount = " + twoCount);
        for(int i = 0; i < nums.length; i ++){
            if(i < zeroCount){
                nums[i] = 0;
            }else if(i >= zeroCount && i < nums.length - twoCount){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }
}
