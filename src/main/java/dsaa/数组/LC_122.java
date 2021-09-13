package dsaa.数组;


//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//         
//
//        示例 1:
//
//        输入: prices = [7,1,5,3,6,4]
//        输出: 7
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//        示例 2:
//
//        输入: prices = [1,2,3,4,5]
//        输出: 4
//        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//             注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//        示例 3:
//
//        输入: prices = [7,6,4,3,1]
//        输出: 0
//        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//         
//
//        提示：
//
//        1 <= prices.length <= 3 * 104
//        0 <= prices[i] <= 104


/**
 * @author zhf
 * @since 2021/5/3 7:29 下午
 **/
public class LC_122 {

    public static void main(String[] args) {
        LC_122 lc = new LC_122();
//        int nums[] = new int[]{7, 1, 5, 3, 6, 4};
//        int nums[] = new int[]{7,6,4,3,1};
//        int nums[] = new int[]{1, 2, 3, 4, 5};
        int nums[] = new int[]{2,1,2,0,1};
        lc.maxProfit(nums);
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        int purchasePoint = -1;
        int salePoint = -1;
        for (int i = 1; i < prices.length; i++) {
            if (purchasePoint == -1 && prices[i] >= prices[i - 1]) { // 如果后面价格大于当前 且当前未持有股票 买入
                purchasePoint = i - 1; // 记录买入的点
                System.out.println("买入价格：" + prices[purchasePoint]);
            }
            if (purchasePoint != -1) { // 已持有股票
                if (prices[i] < prices[i - 1]) { // 跌了 前一天卖掉
                    salePoint = i - 1;
                } else if (i + 1 == prices.length) { // 一直涨 最后一天卖掉
                    salePoint = i;
                }
                if (salePoint != -1) { // 卖出
                    System.out.println("卖出价格：" + prices[salePoint]);
                    total += (prices[salePoint] - prices[purchasePoint]);
                    purchasePoint = -1;
                    salePoint = -1;
                }
            }
        }
        System.out.println("总利润：" + total);
        return total;
    }
}
