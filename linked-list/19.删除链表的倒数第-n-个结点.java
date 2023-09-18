/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode s = new ListNode(-1,head);
            recursion(s, n);
            return s.next;
        }

        private int recursion(ListNode p,int n){
            if(p == null){
                return 0;
            }
            int nth = recursion(p.next, n); // 下一个节点的倒数位置
            if(nth == n){
                p.next = p.next.next;
            }
            return nth + 1;
        }
    */

    // 方法2
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n+1; i++) {
            p2 = p2.next;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }
}
// @lc code=end

