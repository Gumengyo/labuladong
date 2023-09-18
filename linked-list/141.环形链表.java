/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while(h != null && h.next != null){
            t = t.next;
            h = h.next.next;
            if(h == t){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

