package util;

/**
 * User: sam_zhan
 * DateTime: 2021/10/11 12:08 上午
 */
public class ListUtil {


    public static ListNode getListByNums(int[] ints) {
        return new ListNode(ints);
    }

    public static void printList(ListNode head) {
        System.out.println(head.toString());
    }
}