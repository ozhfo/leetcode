package dsaa.链表;

import util.ListNode;

/**
 * User: sam_zhan
 * DateTime: 2021/9/21 9:16 下午
 */
public class LC_61_旋转链表 {

    public static void main(String[] args) {
        // [1,2,3,4,5] 2
        ListNode head = new ListNode();
        ListNode p = head;
        for(int i = 1; i <= 5; i++ ){
            p.next = new ListNode(i);
            p = p.next;
        }
        /** 有点头节点存值 有的不存 本题存 **/
        head = head.next;
        LC_61_旋转链表 lc = new LC_61_旋转链表();
        ListNode newHead = lc.rotateRight(head, 3);
        while(newHead.next != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
        System.out.println(newHead.val);
    }

    public ListNode rotateRight(ListNode oldHead, int k) {
        // 1.移动k个位置 实际是移动 k % N
        // 2.找到倒数第n个点
        int length = 1;
        ListNode p = oldHead;
        while(p.next != null){
            length ++;
            p = p.next;
        }
        int index = k % length;
        p = oldHead;
        if(index != 0){
            // 找到倒数第index个点
            for(int i = 0; i < length - index -1; i++){
                p = p.next;
            }
            // 找到新的头节点
            ListNode newHead = p.next;
            // 尾节点next = null
            p.next = null;
            // 新的链表和旧的链表连起来
            p = newHead;
            while(p.next != null){
                p = p.next;
            }
            // 连起来
            p.next = oldHead;
            oldHead = newHead;
        }
        return oldHead;
    }


    public ListNode rotateRight3(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        ListNode tail = head, newtail = head;
        ListNode newhead;
        int n = 1;
        // 原来的尾结点指向原来的头结点，形成环
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        tail.next = head;
        // 找到断开环的位置
        for(int i = 0; i < (n - k % n - 1); i++){
            newtail = newtail.next;
        }
        // 新的头结点指向断开环的位置
        newhead = newtail.next;
        newtail.next = null;

        return newhead;
    }



    public ListNode rotateRight4(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }



    /**
     * 头结点不存值
     * @param oldHead
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode oldHead, int k) {
        // 1.移动k个位置 实际是移动 k % N
        // 2.找到倒数第n个点
        int length = 0;
        ListNode p = oldHead;
        while(p.next != null){
            length ++;
            p = p.next;
        }
        int index = k % length;
        p = oldHead;
        if(index != 0){
            // 找到倒数第index个点
            for(int i = 0; i < length - index; i++){
                p = p.next;
            }
            // 找到新的头节点
            ListNode newHead = p.next;
            // 尾节点next = null
            p.next = null;
            // 新的链表和旧的链表连起来
            p = newHead;
            while(p.next != null){
                p = p.next;
            }
            // 连起来
            p.next = oldHead.next;
            oldHead = newHead;
        }
        return oldHead;
    }
}