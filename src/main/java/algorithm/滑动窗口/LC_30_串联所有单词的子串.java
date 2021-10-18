package algorithm.滑动窗口;
//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 

//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 554 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LC_30_串联所有单词的子串 {

    public static void main(String[] args) {
        String[] words = new String[]{"bar", "foo", "the"};
        String target = "barfoofoobarthefoobarman";
        LC_30_串联所有单词的子串 lc = new LC_30_串联所有单词的子串();
        lc.findSubstring(target, words);
    }


    public List<Integer> findSubstring(String target, String[] words) {

        // 单词总字符长度
        int wordLength = 0;
        for (String str : words) {
            wordLength += str.length();
        }
        // 边界条件
        char[] array = target.toCharArray();
        List<Integer> result = new ArrayList<>();
        if (array.length < wordLength) {
            return result;
        }
        // 穷举words的所有组合
        List<String> newWords = getWordAll(words);
        for (int i = 0; i < array.length; i++) {
            char[] current = new char[wordLength];
            System.arraycopy(array, i, current, 0, wordLength);
            String str = new String(current);
            if (newWords.contains(str)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 怎么求全排列
     *
     * @param words
     * @return
     */
    private List<String> getWordAll(String[] words) {
        List<String> result = new ArrayList<>();
        // 1个 只有1种排列
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
