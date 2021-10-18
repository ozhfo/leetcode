package algorithm.二分查找;

//一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n
// - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
//
// 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗
// chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
//
// 请你返回需要 补充 粉笔的学生 编号 。

//
// 输入：chalk = [5,1,5], k = 22
//输出：0
//解释：学生消耗粉笔情况如下：
//- 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
//- 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
//- 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
//- 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
//- 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
//- 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
//编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
//

// 输入：chalk = [3,4,1,2], k = 25
//输出：1
//解释：学生消耗粉笔情况如下：
//- 编号为 0 的学生使用 3 支粉笔，然后 k = 22 。
//- 编号为 1 的学生使用 4 支粉笔，然后 k = 18 。
//- 编号为 2 的学生使用 1 支粉笔，然后 k = 17 。
//- 编号为 3 的学生使用 2 支粉笔，然后 k = 15 。
//- 编号为 0 的学生使用 3 支粉笔，然后 k = 12 。
//- 编号为 1 的学生使用 4 支粉笔，然后 k = 8 。
//- 编号为 2 的学生使用 1 支粉笔，然后 k = 7 。
//- 编号为 3 的学生使用 2 支粉笔，然后 k = 5 。
//- 编号为 0 的学生使用 3 支粉笔，然后 k = 2 。
//编号为 1 的学生没有足够的粉笔，所以他需要补充粉笔。
//

//
// chalk.length == n
// 1 <= n <= 105
// 1 <= chalk[i] <= 105
// 1 <= k <= 109
//
// Related Topics 数组 二分查找 前缀和 模拟
// 👍 78 👎 0

/**
 * User: sam_zhan
 * DateTime: 2021/10/14 4:21 下午
 */
public class LC_1894_找到需要补充粉笔的学生编号 {

    public static void main(String[] args) {
        LC_1894_找到需要补充粉笔的学生编号 lc = new LC_1894_找到需要补充粉笔的学生编号();
        int[] nums = new int[]{1};
        int k = 25;
        System.out.println(lc.chalkReplacer(nums, k));
        System.out.println(lc.chalkReplacer2(nums, k));
    }

    /**
     * 前缀和数组
     * 把所有的和都存下来
     * 然后找到k
     * 3 4 1 2 -> 22
     * 3 7 8 10 -> 22
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + chalk[i - 1];
        k = (int)(k % sum[n]);
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (sum[mid] <= k) l = mid;
            else r = mid - 1;
        }
        return sum[r] <= k ? r : r - 1;
    }


    /**
     * 模拟
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer2(int[] chalk, int k) {
        long oneTurnCount = 0;
        for(int num: chalk){
            oneTurnCount += num;
        }
        k %= oneTurnCount;
        // 处理之后的k一定不够一轮 所以问题转变为找到一个k的问题
        int i = 0;
        while(k >= 0){
            if(k < chalk[i]){
                return i;
            }else{
                k = k - chalk[i++];
            }
        }
        return i;
    }

}