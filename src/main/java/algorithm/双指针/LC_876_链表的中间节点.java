package algorithm.双指针;

import util.ListNode;
import util.ListUtil;

//给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
//NULL.
//
//
// 示例 2：
//
//
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//
//
//
// 提示：
//
//
// 给定链表的结点数介于 1 和 100 之间。
//
// Related Topics 链表 双指针
// 👍 415 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * User: sam_zhan
 * DateTime: 2021/10/10 11:57 下午
 */
public class LC_876_链表的中间节点 {

    public static void main(String[] args) {
        LC_876_链表的中间节点 lc = new LC_876_链表的中间节点();
        ListNode head = ListUtil.getListByNums(new int[]{1,2,3,4,5});
        ListUtil.printList(lc.middleNode(head));
        ListNode head2 = ListUtil.getListByNums(new int[]{1,2,3,4,5});
        ListUtil.printList(lc.middleNode2(head2));
    }

    /**
     * 快慢指针
     * 快指针走两步 慢指针走一步
     * 快指针到尾巴的时候 慢指针刚好
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }

    /**
     * 憨比做法
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        int length = 1;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            length ++;
        }
        for(int i = 0; i < length / 2; i++){
            head = head.next;
        }
        return head;
    }
}