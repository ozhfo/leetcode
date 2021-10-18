package algorithm.二分查找;

/**
 * User: sam_zhan
 * DateTime: 2021/10/16 11:45 下午
 */
public class LC_二分查找模板 {

    /**
     * left <= right 则直接一个元素都没有；只能在while里mid赋值
     * left < right 则保证了一个元素；可以用left/right
     * left + 1 < right；因为出来的时候是left + 1 = right 所以保证了两个元素；left和right都能用；排序数组中查找元素的第一个和最后一个位置

     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 10, 11};
        LC_二分查找模板 lc = new LC_二分查找模板();
        int target = 12;
        System.out.println("searchTarget：" + lc.binarySearch(nums,target));
        System.out.println("searchTarget：" + lc.binarySearch2(nums,target));
        System.out.println("searchTarget：" + lc.binarySearch3(nums,target));
        System.out.println("searchTarget：" + lc.binarySearch4(nums,target));
        System.out.println("searchTarget：" + lc.binarySearch5(nums,target));
        System.out.println("searchTarget：" + lc.binarySearch6(nums,target));
    }


    /**
     * 模板一
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }
        return -1;
    }

    /**
     * 模板2
     * @param nums
     * @param target
     * @return
     */
    int binarySearch2(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    /**
     * 模板三
     * @param nums
     * @param target
     * @return
     */
    int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }


    /**
     * 红蓝模板
     */
    int binarySearch4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = -1, right = nums.length;
        while (left + 1 != right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target) return left;
        return -1;
    }


    /**
     * 雪菜模板1
     */
    int binarySearch5(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if(nums[l] == target) return l;
        return -1;
    }

    /**
     * 雪菜模板2
     */
    int binarySearch6(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(nums[l] == target) return l;
        return -1;
    }


}