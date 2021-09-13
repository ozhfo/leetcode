package algorithm.sort;

import org.junit.Test;
import util.ArrayUtil;
import util.PrintUtil;

import java.util.Arrays;

/**
 * 常用排序
 */
public class Sort {

    int[] array = new int[]{8, 9, 1, 7, 5, 4, 2, 3, 6, 0, 10};

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.BubbleSort();
        sort.SortZhf();
        sort.SelectionSort();
        sort.InsertionSort();

    }

    /**
     * 这是好写的排序
     */
    @Test
    public void SortZhf() {
        PrintUtil.bigPrintln("排序zhf");
        for (int i = 0; i < array.length - 1; i++) {
            /** 这个是i 和 后面的每一个j去比较  **/
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    ArrayUtil.swap(array, i, j);
                }
            }
        }
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }


    /**
     * 冒泡排序
     * 时间复杂度 o(n2) -> o(n)
     * 空间复杂度 o(1)
     * 稳定排序
     * 核心：相邻比较交换
     * 1.判断是否交换
     * 2.增加有序边界
     */
    @Test
    public void BubbleSort() {
        PrintUtil.bigPrintln("冒泡排序");
        int lastSwapIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            /** 这里永远是相邻的两位去比较 大的往后走 纯种冒泡思想 **/
            Boolean ifSwap = false;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtil.swap(array, j, j + 1);
                    ifSwap = true;
                    lastSwapIndex = j;
                }
            }
            /** 最后一次发生交换的置为有序边界 **/
            sortBorder = lastSwapIndex;
            if (!ifSwap) {
                /** 纯种冒泡 相邻全部遵循array[i] < array[i+1] 没有发生过交换 那么已经有序 **/
                break;
            }
        }
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }


    /**
     * 选择排序
     * 时间复杂度 o(n2)
     * 空间复杂度 o(1)
     * 不稳定排序
     * 核心:找到最小的一个跟当前的比较交换
     */
    @Test
    public void SelectionSort() {
        PrintUtil.bigPrintln("选择排序");
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                ArrayUtil.swap(array, i, minIndex);
            }
        }
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }

    /**
     * 插入排序->傻屌算法
     * 时间O(n2) -> O(n)
     * 空间O(1)
     * 稳定排序
     * 核心思想：假定前面的有序 后面的元素在前面找到适合自己的位置插入进去
     */
    @Test
    public void InsertionSort() {
        PrintUtil.bigPrintln("插入排序");
        int temp;
        // i = 1
        for (int i = 1; i < array.length; i++) {
            // 把i的数据提出来 数组往后挪
            temp = array[i];
            int j;
            if (array[i - 1] > temp) {

                for (j = i - 1; j >= 0; j--) {
                    if (array[j] > temp) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
//                j = i - 1;
//                while(j >= 0 && array[j] > temp){
//                    array[j+1] = array[j--];
//                }

                //插入到合适位置
                array[j + 1] = temp;
            }
        }
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }


    /**
     * https://www.cnblogs.com/chengxiao/p/6104371.html
     * 希尔排序-高级插入排序
     * O(n1.3-n2)
     * O(1)
     * 不稳定的排序
     * 同插入排序 多了一个希尔增量的概念 区间逐步有序
     */
    public static void ShellSort(int[] nums) {
        PrintUtil.bigPrintln("希尔排序");
        int increment = nums.length;
        //注意看结束条件
        while (increment > 1) {
            //这里可以自己设置
            increment = increment / 2;
            //根据增量分组
            for (int i = 0; i < increment; ++i) {
                //这快是不是有点面熟，回去看看咱们的插入排序
                for (int j = i + increment; j < nums.length; ++j) {
                    int temp = nums[j];
                    int k;
                    for (k = j - increment; k >= 0; k -= increment) {
                        if (temp < nums[k]) {
                            nums[k + increment] = nums[k];
                            continue;
                        }
                        break;
                    }
                    nums[k + increment] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    /**
     * 归并排序
     * 分治
     */
    public static void MergeSort(int[] array) {

    }

    /**
     * 快速排序
     * 找一个基准 左边的小 右边的大
     */
    public static void QuickSort(int left, int right, int[] array) {

    }

    /**
     * 计数排序
     */
    public static void CountingSort(int[] array) {

    }

    /**
     * 桶排序
     */
    public static void BucketSort(int[] array) {

    }

    /**
     * 基数排序
     */
    public static void RadixSort(int[] array) {

    }

}
