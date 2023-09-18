/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    // 方法1
    /*
     * public ListNode deleteDuplicates(ListNode p) {
     * if(p == null || p.next == null){
     * return p;
     * }
     * 
     * if(p.val == p.next.val){
     * ListNode x = p.next.next;
     * while(x != null && x.val == p.val){
     * x = x.next;
     * }
     * return deleteDuplicates(x);
     * }else{
     * p.next = deleteDuplicates(p.next);
     * return p;
     * }
     * }
     */

    // 方法2
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2,p3;
        while((p2 = p1.next) != null
                && (p3 = p2.next) != null){
            if(p2.val == p3.val){
                while((p3=p3.next) != null && p3.val == p2.val){
                }
                // p3 找到了不重复的值
                p1.next = p3;
            }else{
                p1 = p1.next;
            }
        }
        return s.next;
    }
}
// @lc code=end
