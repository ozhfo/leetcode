package algorithm.greedy;


//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i
//]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
//

//
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释:
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
//

//
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释:
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.

// 1 <= g.length <= 3 * 104
// 0 <= s.length <= 3 * 104
// 1 <= g[i], s[j] <= 231 - 1
//
// Related Topics 贪心算法
// 👍 330 👎 0


import java.util.Arrays;

/**
 * @author zhf
 * @since 2021/5/21 5:16 下午
 **/
public class LC_455 {

    public static void main(String[] args) {
        int g[] = new int[]{2, 2, 3};
        int s[] = new int[]{1, 1};
        LC_455 lc = new LC_455();
        System.out.println("result " + lc.findContentChildren(g,s));
    }

    /**
     * 先排序再贪心
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0; //小孩
        for (int foodIndex = 0; foodIndex < s.length && childIndex < g.length; foodIndex++) {
            if(s[foodIndex] >= g[childIndex]){
                // 如果最小的食物能满足小孩子 那么满足的数量+1  否则换大一点的食物再来一次
                childIndex ++;
            }
        }
        return childIndex;
    }

}