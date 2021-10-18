package algorithm.二分查找;

/**
 * User: sam_zhan
 * DateTime: 2021/10/16 11:45 下午
 */
public class LC_二分查找最强模板 {

    /**
     * left + 1 < right；因为出来的时候是left + 1 = right 所以保证了两个元素；left和right都能用；排序数组中查找元素的第一个和最后一个位置
     * left < right 则保证了一个元素；可以用left/right
     * left <= right 则直接一个元素都没有；只能在while里mid赋值
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 5, 5, 8, 9};
        LC_二分查找最强模板 lc = new LC_二分查找最强模板();
        System.out.println("找第一个>=5：" + lc.findX(nums));
        System.out.println("找第一个>=5：" + lc.findX5(nums));
        System.out.println("找最后一个<5：" + lc.findX2(nums));
        System.out.println("找最后一个<5：" + lc.findX6(nums));
        System.out.println("找第一个>5：" + lc.findX3(nums));
        System.out.println("找第一个>5：" + lc.findX7(nums));
        System.out.println("找最后一个<=5：" + lc.findX4(nums));
        System.out.println("找最后一个<=5：" + lc.findX8(nums));
    }


    /**
     * 确定边界 特殊情况排除 数据一定在区间内
     * 二分框架
     * check性质
     * 区间更新
     *
     */

    /**
     * 第一个大于等于5
     * @param nums
     * @return
     */
    public int findX(int[] nums) {
        int left = -1, right = nums.length;
        while(left + 1 != right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < 5){
                left = middle;
            }else{
                right = middle;
            }
        }
        return right;
    }

    /**
     * 第一个大于等于5
     *
     * @param nums
     * @return
     */
    public int findX5(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid  = l + r + 1>> 1;
            if(nums[mid] < 5){
                // 最终得到的是<5的最后一个值
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }

    /**
     * 找最后一个<5
     * @param nums
     * @return
     */
    public int findX2(int[] nums) {
        int left = -1, right = nums.length;
        while(left + 1 != right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < 5){
                left = middle;
            }else{
                right = middle;
            }
        }
        return left;
    }

    /**
     * 找最后一个<5
     * @param nums
     * @return
     */
    public int findX6(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid  = l + r + 1>> 1;
            if(nums[mid] < 5){
                // 最终得到的是<5的最后一个值
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 找第一个>5
     * @param nums
     * @return
     */
    public int findX3(int[] nums) {
        int left = -1, right = nums.length;
        while(left + 1 != right){
            int middle = left + (right - left) / 2;
            if(nums[middle] <= 5){
                left = middle;
            }else{
                right = middle;
            }
        }
        return right;
    }

    /**
     * 找第一个>5
     * @param nums
     * @return
     */
    public int findX7(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid  = l + r >> 1;
            if(nums[mid] <= 5){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    /**
     * 找最后一个<=5
     * @param nums
     * @return
     */
    public int findX4(int[] nums) {
        int left = -1, right = nums.length;
        while(left + 1 != right){
            int middle = left + (right - left) / 2;
            if(nums[middle] <= 5){
                left = middle;
            }else{
                right = middle;
            }
        }
        return left;
    }

    /**
     * 找最后一个<=5
     * @param nums
     * @return
     */
    public int findX8(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid  = l + r + 1>> 1;
            if(nums[mid] <= 5){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }


}