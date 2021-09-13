package dsaa.数组;


//给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
//
//        h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
//
//        例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
//        示例：
//
//        输入：citations = [3,0,6,1,5]
//        输出：3
//        解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//             由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
//         
//        提示：如果 h 有多种可能的值，h 指数是其中最大的那个。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/h-index
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.Arrays;

/**
 * @author zhf
 * @since 2021/7/11 10:09 下午
 **/
public class LC_274 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1};
        LC_274 lc = new LC_274();
        System.out.println(lc.hIndex(nums));
        System.out.println(lc.hIndex2(nums));
        System.out.println(lc.hIndex2(nums));
        System.out.println(lc.hIndex2(nums));
    }



    /**
     * [0,1,3,5,6]
     * [100]
     * [1,3,1]
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        //二分引用次数
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(citations,mid)){
                left = mid + 1;
            }else{
                right= mid - 1;
            }
        }
        return right;
    }


    public boolean check(int[] citations, int mid) {
        int count = 0;
        for (int citation : citations) {
            //如果论文引用次数 >= 当前引用次数,符合要求的篇数+1
            if(citation >= mid){
                count++;
            }
        }
        //如果符合要求篇数>=引用次数,则当前值可以为H指数
        return count >= mid;
    }


    //    根据题意，我们需要找到满足条件「引用次数至少为 xx 次的 xx 篇论文」中的最大 xx 值。
//    那么在以最大值 xx 为分割点的正整数数轴上，满足二段性：
//    少于等于 xx 的数值必然满足条件；
//    大于 xx 的数值必然不满足。
    public int hIndex2(int[] cs) {
        int left = 0, right = cs.length;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(cs, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


    /**
     * 官方题解
     *
     * @param citations
     * @return
     */

    public int hIndex3(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * 官方题解2
     */
    public int hIndex4(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }







}
