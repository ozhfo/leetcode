package util;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtil {

    /**
     * @param start
     * @param intervals
     */
    public static void printDoubleArray(String start, int[][] intervals) {
        System.out.println(start);
        for (int[] temp : intervals) {
            for (int a : temp) {
                System.out.print(a + " ");
            }
            System.out.println("\n");
        }
    }


    /**
     * @param start
     * @param intervals
     */
    public static void printArray(int[] intervals, String start) {
        System.out.println(start);
        for (int a : intervals) {
            System.out.print(a + " ");
        }
        System.out.println("\n");
    }

    public static void swap(int[] num, int left, int right) {
        if(left != right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
        }
    }

    public static int[] getShuffleArray(int end) {
        int[] nums =  IntStream.rangeClosed(1,end).toArray();
        nums = shuffle(nums);
        printArray(nums, "准备一个乱序数组");
        return nums;
    }

    /**
     * 有序且重复数组
     * @return
     */
    public static int[] getSortedRepeatArray(){
        return new int[]{3,2,2,3};
    }



    /**
     * 数组乱序
     * @param arr
     * @return
     */
    private static  int[] shuffle(int [] arr) {
        int runCount = 0 ;
        int [] arr2 =new int[arr.length];
        int count = arr.length;
        // 索引
        int cbRandCount = 0;
        // 位置
        int cbPosition = 0;
        int k =0;
        do {
            runCount++;
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            arr2[k++] = arr[cbPosition];
            cbRandCount++;
            // 将最后一位数值赋值给已经被使用的cbPosition
            arr[cbPosition] = arr[r - 1];
        } while (cbRandCount < count);
        System.out.println("运算次数  = "+ runCount);
        return arr2;
    }


    public static void main(String[] args) {
        getShuffleArray(20);
    }


}
