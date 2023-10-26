/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {    
    // 方法1
    /* 
        public ListNode deleteDuplicates(ListNode head) {
            // 节点数 < 2
            if(head == null || head.next == null){
                return head;
            }
            // 节点数 >= 2
            ListNode p1 = head;
            ListNode p2;
            while((p2 = p1.next) != null){
                if(p1.val == p2.val){
                    // 删除 p2
                    p1.next = p2.next;
                }else{
                    // 向后平移
                    p1 = p1.next;
                }
            }
            return head;
        }
    */

    // 方法2
    // public ListNode deleteDuplicates(ListNode p) {
    //    if(p == null || p.next == null){
    //         return p;
    //    }

    //    if(p.val == p.next.val){
    //         return deleteDuplicates(p.next);
    //    }else{
    //         p.next = deleteDuplicates(p.next);
    //         return p;
    //    }
        
    // }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(slow.val != fast.val){
                slow = slow.next;
                slow.val = fast.val;
            }   
            fast = fast.next;
        }
        slow.next = null;
        return head;
     }
}
// @lc code=end

