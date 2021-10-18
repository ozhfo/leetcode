package algorithm.二分查找;

//    https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/


/**
 * User: sam_zhan
 * DateTime: 2021/10/4 3:31 下午
 */
public class LC_69_X的平方根 {

    public static void main(String[] args) {
        int x = 2147483647;
        LC_69_X的平方根 lc = new LC_69_X的平方根();
        System.out.println(lc.mySqrt(x));
        System.out.println(lc.mySqrt3(x));
        System.out.println(lc.mySqrt4(x));
        System.out.println(lc.mySqrt5(x));
        System.out.println(lc.mySqrt6(x));
        for (int tt = 0; tt <= 100; tt++) {
            System.out.println(tt + "的开平方 =" + lc.mySqrt(tt));
        }
    }

    /**
     * 官方题解
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long result = (long) mid * mid;
            if (result <= x) {
                // left和结果分开 不用在return的时候考虑取值
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 雪菜版本
     * l = mid r = mid -1  mid = l + r + 1 >> 1
     * @param x
     * @return
     */
    public int mySqrt6(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mid <= x / mid) {
                // 2 3 8
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    /**
     * 红蓝区域模板
     * @param x
     * @return
     */
    public int mySqrt5(int x) {
        long left = 0, right = (long) x + 1;
        while (left + 1 != right) {
            long middle = left + (right - left) / 2;
            long temp = middle * middle;
            if (temp <= x) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (int) left;
    }



    /**
     * 袖珍计算器
     *
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
     *
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

}