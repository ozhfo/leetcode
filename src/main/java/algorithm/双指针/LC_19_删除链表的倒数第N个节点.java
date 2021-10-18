package algorithm.双指针;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？

//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//

//输入：head = [1], n = 1
//输出：[]
//

//输入：head = [1,2], n = 1
//输出：[1]
//

// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1603 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import util.ListNode;

/**
 * User: sam_zhan
 * DateTime: 2021/10/10 11:57 下午
 */
public class LC_19_删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        LC_19_删除链表的倒数第N个节点 lc = new LC_19_删除链表的倒数第N个节点();
        System.out.println(lc.removeNthFromEnd(head, 7));
        head = new ListNode(nums);
        System.out.println(lc.removeNthFromEnd2(head, 7));
    }

    /**
     * 先算出长度
     * 然后确定删除的节点位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode index = head;
        while(index.next != null){
            index = index.next;
            length ++;
        }
        // 正序 第0个 第1个 第2个
        int order = length - n;
        if(order == 0){
            head = head.next;
        }else if(order > 0){
            index = head;
            for(int i = 0; i < order - 1; i++){
                index = index.next;
            }
            index.next = index.next.next;
        }
        return head;
    }

    /**
     * 1 2 3 4 5 6 7 null
     * 3
     *
     * 快慢指针！！！ 憨比
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = new ListNode(), fast = head;
        slow.next = head;
        int i = 1;
        while(fast.next != null){
            i++;
            fast = fast.next;
            if(i > n){
                slow = slow.next;
            }
        }
        if(slow.next != null) {
            if (slow.next == head) {
                head = head.next;
            } else {
                slow.next = slow.next.next;
            }
        }
        return head;
    }

    /**
     * 返回pre.next 因为head可能被删除了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }



}