package 剑指offer;


//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
//
//
// 示例 1：
//
// 输入: n = 3
//输出: 6
//
//
// 示例 2：
//
// 输入: n = 9
//输出: 45
//
//
//
//
// 限制：
//
//
// 1 <= n <= 10000
//
// 👍 305 👎 0



/**
 * @author zhf
 * @since 2021/4/10 3:18 下午
 **/
public class JZ_64 {

    /**
     *   不能使用 乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     */
    public static void main(String[] args) {
        System.out.println(sumNums2(100));
    }

    /**
     * 递归
     */
    public static int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    /**
     * 利用&&代替判断
     * n = 1 终止递归
     */
    public static int sumNums2(int n){
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }


    /**
     * try catch
     */
    int[] nums = new int[1];

    public int sumNums3(int n) {
        try {
            //只有当n等于1的时候，这里才返回
            //否则就走最下面的return
            return nums[n - 1] + 1;
        } catch (Exception e) {

        }
        return n + sumNums3(n - 1);
    }
}
