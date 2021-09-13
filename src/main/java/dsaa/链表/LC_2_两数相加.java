package dsaa.链表;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

// 示例 1：
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
// 示例 3：
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]

//
// 提示：
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
// Related Topics 递归 链表 数学
// 👍 6217 👎 0


/**
 * @author zhf
 * @since 2021/5/21 10:00 下午
 **/
public class LC_2_两数相加 {

    public static void main(String[] args) {
        ListNode list10 = new ListNode(2);
        ListNode list11 = new ListNode(4);
        ListNode list12 = new ListNode(3);
        list10.next = list11;
        list11.next = list12;
        list12.next = null;


        ListNode list20 = new ListNode(5);
        ListNode list21 = new ListNode(6);
        ListNode list22 = new ListNode(4);
        list20.next = list21;
        list21.next = list22;
        list22.next = null;

        LC_2_两数相加 lc = new LC_2_两数相加();
        ListNode result = lc.addTwoNumbers(list10, list20);
        while(result.next != null){
            System.out.print(result.next);
            result = result.next;
        }
        System.out.println(result);
    }


    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        int t = 0, carry = 0;
        while(l1.next != null || l2.next != null){
            t = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val: 0) + carry;
            carry = t / 10;
            t = t % 10;
            ListNode cur = new ListNode(t);
            pre.next = cur;
            if(head.next == null){
                head.next = cur;
            }
            pre = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode() {

        }
    }

}
