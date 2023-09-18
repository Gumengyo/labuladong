/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    /*
     * 步骤1. 找中间点
     * 步骤2. 中间点后半个链表反转
     * 步骤3. 反转后链表与原链表逐一比较
     */
    /*  优化前
        public boolean isPalindrome(ListNode head) {
            ListNode middle = middle(head);
            ListNode newHead = reverse(middle);
            while (newHead != null) {
                if (newHead.val != head.val) {
                    return false;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverse(ListNode o1) {
            ListNode n1 = null;
            while (o1 != null) {
                ListNode o2 = o1.next;
                o1.next = n1;
                n1 = o1;
                o1 = o2;
            }
            return n1;
        }

        private ListNode middle(ListNode head) {
            ListNode p1 = head; // 慢
            ListNode p2 = head; // 快
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return p1;
        }
    */

    /*
     * 步骤1. 找中间点的同时反转前半个链表
     * 步骤2. 反转后的前半个链表 与 中间点开始的后半个链表 逐一比较
     */
    // 优化后

    public boolean isPalindrome(ListNode head){
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        ListNode n1 = null; // 新头
        ListNode o1 = head; // 旧头
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if(p2 != null){
            p1 = p1.next;
        }
        while(n1 != null){
            if(n1.val != p1.val){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}
// @lc code=end
