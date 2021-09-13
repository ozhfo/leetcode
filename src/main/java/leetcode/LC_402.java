package leetcode;

/**
 * TODO
 *
 * @author zhf
 * DateTime: 2020/11/15 11:23 下午
 */
public class LC_402 {

    /**
     * 给定一个以字符串表示的非负整数
     * num，移除这个数中的 k 位数字，使得剩下的数字最小。
     *
     * 注意:
     *
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     * 示例 1 :
     *
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     * 示例 2 :
     *
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     * 示例 3 :
     *
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     */

    /**
     * TODO@LC
     * @param args
     */
    public static void main(String[] args) {
        // "3481236879";
        // k = 4 看k+1位 hadIndex = 3 minIndex = 3 ###132 先把前面的3个删了 保留132 我还可以再删一位 第一个不动 从第二个开始 那么看2位
        // k = 1 看k+位
//        String num = "3481236879";
        String num = "10200";
        String minNum= removeKDigits(num,1);
        System.out.println("minNum = " + minNum);
    }

    public static String removeKDigits(String num, int k) {
        char[] digits = num.toCharArray();
        int hadDealIndex = -1;
        while(k > 0){
            int left = hadDealIndex + 1;
            int minCharIndex = left;
            int minValue =digits[left];
            for(int i = left + 1; i < left + k + 1 && i < digits.length; i++){
                if(minValue > digits[i]){
                    minCharIndex = i;
                    minValue = digits[i];
                }
            }
            // remove 0-minCharIndex;
            for(int i = hadDealIndex + 1; i < minCharIndex; i++){
                digits[i] = '#';
            }
            k = k - minCharIndex + hadDealIndex + 1;
            hadDealIndex = minCharIndex;
        }
        System.out.println(digits.toString());
        return String.valueOf(digits);
    }
}