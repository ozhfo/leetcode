package algorithm.二分查找;


/**
 * 猜数字
 *
 */
public class LC_374_猜数字 {

    public static void main(String[] args) {
        LC_374_猜数字 lc = new LC_374_猜数字();
        lc.myGuessNumber();
    }

    private int myGuessNumber() {
        int left = 0; int right = Integer.MAX_VALUE;
        while(left <= right){
            int middle = (right - left) / 2 + left;
            if(guess(middle) == 1){
                left = middle + 1;
            }else if(guess(middle) == -1){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    public int guess(int n) {
        return -1;
    }
}
