package dsaa.链表;

/**
 * User: sam_zhan
 * DateTime: 2021/9/24 9:26 下午
 */
public class 混子 {

    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7}; int k = 3;
    }

    public void getK(int[] nums, int k){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        // 第一轮遍历k记录 max和second
        for(int i = 0  ; i < nums.length; i++){
            if(i < k){
                if(nums[i] > max){
                    max = nums[i];
                    maxIndex = i;
                }
            }else{
                if(maxIndex > i - k){
                    // max还在
                    if(nums[i] > max){
                        max = nums[i];
                        maxIndex = i;
                    }
                }else{
                    // max被挪丢了
                }
            }
        }

    }
}