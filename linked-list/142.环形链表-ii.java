/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while(h != null && h.next != null){
            t = t.next;
            h = h.next.next;
            if(h == t){
                // 进入第二阶段
                t = head;
                while(true){
                    if(t == h){
                        return t;
                    }
                    t = t.next;
                    h = h.next; 
                }
            }
        }
        return null;
    }
}
// @lc code=end

