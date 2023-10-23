/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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

    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1,null);
        ListNode p = s;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        return s.next;
    }
    

    // 方法2
    // public ListNode mergeTwoLists(ListNode p1,ListNode p2){

    //     if(p2 == null){
    //         return p1;
    //     }

    //     if(p1 == null){
    //         return p2;
    //     }

    //     if(p1.val < p2.val){
    //         p1.next = mergeTwoLists(p1.next, p2);
    //         return p1;
    //     }else{
    //         p2.next = mergeTwoLists(p1,p2.next);
    //         return p2;
    //     }
    // }
}
// @lc code=end

