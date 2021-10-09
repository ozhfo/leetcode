package dsaa.栈;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */


import java.util.*;

/**
 * User: sam_zhan
 * DateTime: 2021/9/13 10:02 下午
 */
public class LC_394 {

    int ptr = 0;


    public static void main(String[] args) {
        String str = "abc3[ab[dc]2[fg]]def";
//        String str = "3[a2[c]]";
        LC_394 lc = new LC_394();
//        System.out.println("解法1:" + lc.decodeString(str));
        System.out.println("解法2:" + lc.decodeString2(str));
    }



    public String decodeString2(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuffer> strStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            // abc3[ab2[fg]]def
            if (Character.isDigit(c)) {
                // 数字取出来
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                // 遇到"["将当前环境入栈
                strStack.add(result);
                numStack.add(multi);
                result = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                // 字符直接记录
                result.append(c);
            } else {
                // 遇到】取出栈字符串
                // (popStr)3[subStr] = popStr + num * subStr
                StringBuffer ansTmp = strStack.pop();
                int num = numStack.pop();
                for (int i = 0; i < num; i++) {
                    ansTmp.append(result);
                }
                result = ansTmp;
            }
        }
        return result.toString();
    }


    public String decodeString3(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c); // 把所有的字母push进去，除了]
            } else {
                //step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString(); //[ ]内的字符串
                stack.pop(); // 去除[
                //step 2: 获取倍数数字
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString()); //倍数
                //step 3: 根据倍数把字母再push回去
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }

        return retv.toString();
    }

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public String decodeString4(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


    public String decodeString5(String s) {
        char[] cs = s.toCharArray();
        int len = s.length(), num = 0;
        Deque<String> stk_s = new ArrayDeque<>();
        Deque<Integer> stk_n = new ArrayDeque<>();
        //将字符串按规则解码，并放入栈内
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == '[') {
                //记录该左括号的对应数字
                stk_n.push(num);
                num = 0;
                stk_s.push("[");
            } else if (c == ']') {
                //结算该右括号内的字符
                StringBuilder temp = new StringBuilder();
                //获取这对括号内的字符
                while (!stk_s.isEmpty() && stk_s.peek() != "[") {
                    temp.append(stk_s.poll());
                }
                stk_s.poll();
                //获取这对括号对应的数字k，并放入栈内k次
                int k = stk_n.poll();
                for (int j = 0; j < k; j++) {
                    stk_s.push(temp.toString());
                }
            } else if (Character.isDigit(c)) {
                //更新数字
                num = num * 10 + cs[i] - '0';
            } else {
                StringBuilder temp = new StringBuilder();
                //反着放入这对括号的字符到栈内
                while (i < len && Character.isLetter(cs[i])) {
                    temp.append(cs[i++]);
                }
                stk_s.push(temp.reverse().toString());
                i--;
            }
        }
        //取出栈内以解码好的所有字符进行拼接
        StringBuilder ans = new StringBuilder();
        while (!stk_s.isEmpty()) {
            ans.append(stk_s.poll());
        }
        //放入栈内的字符全是反的，因此拼接完要反回来
        return ans.reverse().toString();
    }


}