package util;


import lombok.Data;

/**
  User: sam_zhan
  DateTime: 2021/9/21 9:16 下午
 */

@Data
public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


      /** 通过数组构造ListNode **/
       public ListNode(int[] nums) {
            if (nums == null || nums.length == 0) {
                  throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = nums[0];
            ListNode curr = this;
            for (int i = 1; i < nums.length; i++) {
                  curr.next = new ListNode(nums[i]);
                  curr = curr.next;
            }
      }

      @Override
      public String toString() {
            StringBuilder s = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                  s.append(cur.val);
                  s.append(" -> ");
                  cur = cur.next;
            }
            s.append("NULL");
            return s.toString();
      }
  }