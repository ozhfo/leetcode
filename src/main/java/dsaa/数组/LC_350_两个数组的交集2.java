package dsaa.数组;

//给定两个数组，编写一个函数来计算它们的交集。
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]

// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]

// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//

// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 491 👎 0

import util.ArrayUtil;

import java.util.*;

/**
 * @author zhf
 * @since 2021/5/24 9:06 下午
 **/
public class LC_350_两个数组的交集2 {

    public static void main(String[] args) {
        LC_350_两个数组的交集2 lc = new LC_350_两个数组的交集2();
        int[] a1 = new int[]{4, 4, 7, 9, 9, 4, 9, 5};
        int[] a2 = new int[]{9, 4, 9, 8, 4, 4};
        int[] a3 = lc.intersectGood(a1, a2);
        ArrayUtil.printArray(a3, "无序");
        int[] a4 = lc.intersect2(a1, a2);
        ArrayUtil.printArray(a4, "有序");
    }

    /**
     * map解法 官方
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectGood(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 只处理 nums1<nums2
            return intersectGood(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            //nums1进map
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            //遍历nums2 如果存在那么nums1减一
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


    /**
     * 已经排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0, k = 0;
        List<Integer> list = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1++]);
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}
