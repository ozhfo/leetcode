package leetcode.done;


import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_204 {

    /**
     * https://leetcode-cn.com/problems/count-primes/
     * <p>
     * 统计所有小于非负整数 n 的质数的数量。
     * 示例 1：
     * <p>
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     * <p>
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：n = 1
     * 输出：0
     */

    public static void main(String[] args) {
        int n = 10000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        solution(n);
        stopWatch.stop();
        System.out.println("\n--------------" + stopWatch.getLastTaskTimeMillis());
        stopWatch.start();
        solution2(n);
        stopWatch.stop();
        System.out.println("\n--------------" + stopWatch.getLastTaskTimeMillis());
        stopWatch.start();
        solution3(n);
        stopWatch.stop();
        System.out.println("\n--------------" + stopWatch.getLastTaskTimeMillis());
        stopWatch.start();
        solution4(n);
        stopWatch.stop();
        System.out.println("\n--------------" + stopWatch.getLastTaskTimeMillis());
    }

    /**
     * 计算质数
     *
     * @param n
     */
    private static void solution(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeNumber(i)) {
                ans += 1;
                System.out.print(i + " ");
            }
        }
        System.out.println("\n ans = " + ans);
    }

    /**
     * 判断10是不是素数 11/2 11/3
     * y/x1 = x2 那么x1一定小于x2 ---> 就没必要去遍历x1后面的数字
     *
     * @param n
     * @return
     */
    private static boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 优化
     * 2*2 2*3 2*4 2*5 2*6
     * 3*3 3*4 3*5
     * 4*4 4*5 4*6 4*7
     * 被留下来的数自然就是质数
     */
    private static void solution2(int n) {
        int[] array = new int[n];
        Arrays.fill(array, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                ans += 1;
                /** long 不然会超出int **/
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        array[j] = 0;
                    }
                }
            }
        }
        for (int j = 2; j < n; j++) {
            if (array[j] == 1) {
                System.out.print(j + " ");
            }
        }
        System.out.println("\n ans = " + ans);
    }


    /**
     * 优化
     * 2走所有的倍数 2*2 2*3 2*4 2*5 2*6 2*7 2*8 2*9 2*10  n = 100
     * 2走完之后的结果:2 3 5 7 9 11 13 15 17 19 21 23 25 27 29
     * 3走奇数倍 3*3  3*5  3*7  3*9 30
     * 3走完的结果: 2 3 5 7 11 13 17 19 23 27 29
     * 5走完的结果 干掉25
     * <p>
     * TODO
     */
    private static void solution3(int n) {
        int[] array = new int[n];
        Arrays.fill(array, 1);
        int k = 2;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    if (i > 2) {
                        k = i + i;
                    }
                    for (int j = i * i; j < n; j += k) {
                        array[j] = 0;
                    }
                }
            }
        }
        for (int j = 2; j < n; j++) {
            if (array[j] == 1) {
                System.out.print(j + " ");
            }
        }
        System.out.println("\n ans = " + ans);
    }

    /**
     * 看不懂TODO
     * @param n
     * @return
     */
    private static Integer solution4(int n){
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        primes.stream().forEach(x -> System.out.print(x + " "));
        System.out.println("\n ans = " + primes.size());
        return primes.size();

    }
}
