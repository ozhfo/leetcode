package dsaa.数组;
//给定一个正整数 n ，输出外观数列的第 n 项。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
//
// 你可以将其视作是由递归公式定义的数字字符串序列：
//
//
// countAndSay(1) = "1"
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
//
//
// 前五项如下：
//
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
//
//
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
//
// 例如，数字字符串 "3322251" 的描述如下图：
//

//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
//
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
//
// 1 <= n <= 30
//
// Related Topics 字符串
// 👍 776 👎 0


/**
 * User: sam_zhan
 * DateTime: 2021/10/15 11:12 上午
 */
public class LC_38_外观数列 {

    public static void main(String[] args) {
        LC_38_外观数列 lc = new LC_38_外观数列();
        System.out.println(lc.countAndSay(7));
        System.out.println(lc.countAndSay2(7));
        System.out.println(lc.countAndSay3(7));
    }

    /**
     * 每一步都依赖于上一步的结果
     * 递归
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String lastResult = countAndSay(n - 1);
        Character current = lastResult.toCharArray()[0];
        int charCount = 0;
        StringBuilder result = new StringBuilder();
        for (Character character : lastResult.toCharArray()) {
            if (current.equals(character)) {
                charCount++;
            } else {
                //存下之前的数字 切换当前的数字
                result.append(charCount).append(current);
                current = character;
                charCount = 1;
            }
        }
        // 憨比 最后一次循环需要额外处理
        result.append(charCount).append(current);
        return result.toString();
    }

    /**
     * 模拟
     *
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            String cur = "";
            int m = ans.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && ans.charAt(j) == ans.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + ans.charAt(j);
                j = k;
            }
            ans = cur;
        }
        return ans;
    }

    /**
     * 因为数据范围只有1-30
     * 所以打表
     *
     * @param n
     * @return
     */
    public String countAndSay3(int n) {
        return f[n];
    }

    static String[] f = new String[35];

    static {
        f[1] = "1";
        for (int i = 2; i < 35; i++) {
            String prev = f[i - 1], cur = "";
            int m = prev.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && prev.charAt(j) == prev.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + prev.charAt(j);
                j = k;
            }
            f[i] = cur;
        }
    }


}