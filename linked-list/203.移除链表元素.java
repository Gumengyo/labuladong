/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode s = new ListNode(-1,head);
            ListNode p1 = s;
            ListNode p2;
            while((p2 = p1.next) != null){
                if(p2.val == val){
                    // 删除
                    p1.next = p2.next;
                }else{
                    p1 = p1.next;
                }
            }
            return s.next;
        } 
     */
 
    // 方法2
    public ListNode removeElements(ListNode p,int val){
        if(p == null){
            return null;
        }
        if(p.val == val){
            return removeElements(p.next,val);
        }else{
            p.next = removeElements(p.next,val);
            return p;
        }
    }
}
// @lc code=end

