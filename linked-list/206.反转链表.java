/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
        public ListNode reverseList(ListNode head) {
            ListNode n1 = null;
            ListNode p = head;
            while(p != null){
                n1 = new ListNode(p.val,n1);
                p = p.next;  
            }
            return n1;
        } 
    */

    // 方法2
    /* 
        public ListNode reverseList(ListNode head){
            List list1 = new List(head);
            List list2 = new List(null);
            while(true){
                ListNode first = list1.removeFirst();
                if(first == null){
                    break;
                }
                list2.addFirst(first);
            }
            return list2.head;
        }

        static class List{
        ListNode head;

        public List(ListNode head){
            this.head = head;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    
        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }
    }
    */

    // 方法3
    /* 
        public ListNode reverseList(ListNode p){
            if(p == null || p.next == null){
                return p; // 最后节点
            }
            ListNode last = reverseList(p.next);
            p.next.next = p;
            p.next = null;
            return last;
        }
    */

    // 方法4
    /* 
        public ListNode reverseList(ListNode o1){

            if(o1 == null || o1.next == null){
                return o1;
            }

            ListNode o2 = o1.next;
            ListNode n1 = o1;
            while(o2 != null){
                o1.next = o2.next;
                o2.next = n1;
                n1 = o2;
                o2 = o1.next;
            }
            return n1;
        }
    */
    
    // 方法5
    public ListNode reverseList(ListNode o1){
        if(o1 == null || o1.next == null){
            return o1;
        }

        ListNode n1 = null;
        while(o1 != null){
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }
}
// @lc code=end

