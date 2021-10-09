package algorithm.二分查找;

//    https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/


/**
 * User: sam_zhan
 * DateTime: 2021/10/4 3:31 下午
 */
public class LC_69_X的平方根 {


    public static void main(String[] args) {
        int x = 1983234234;
        LC_69_X的平方根 lc = new LC_69_X的平方根();
        System.out.println(lc.mySqrt2(x));
        System.out.println(lc.mySqrt(x));
    }

    /**
     * 题解
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long result = (long) mid * mid;
            if (result <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 袖珍计算器
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     * 牛顿迭代
     * @param x
     * @return
     */
    public int mySqrt4(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


    /**
     * 我的二分
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        // 二分
        int left = 1, right = x;
        while(left < right){
            int middle = left + (right - left ) / 2;
            long result = (long) middle * middle;
            if(result < x){
                left = middle + 1;
            }else if(result > x){
                right = middle;
            }else{
                return middle;
            }
        }
        return left - 1;
    }
}