/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
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

// 方法1
/*
 * class Solution {
    private static ListNode mergeTwoLists(ListNode p1, ListNode p2) {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return split(lists, 0, lists.length-1);
        
    }

    // 返回合并后的链表, i , j 代表左右边界
    private ListNode split(ListNode[] lists, int i, int j){
        if(i == j){ // 数组内只有一个链表
            return lists[i];
        }
        int m = (i+j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists,m+1,j);
        return mergeTwoLists(left,right);
    }
}
 */

 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1. 将链表的头节点加入小顶堆
        for (ListNode h : lists) {
            if(h != null){
                heap.offer(h);
            }
        }

        // 2. 不断从堆顶移除最小元素，加入新链表
        ListNode s = new ListNode(-1,null);
        ListNode t = s;
        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            if(min.next != null){
                heap.offer(min.next);
            }
        }
        

        return s.next;
        
    }

    class MinHeap {

        ListNode[] array;
        int size;
    
        public MinHeap(int capacity) {
            array = new ListNode[capacity];
        }
    
        public void offer(ListNode offered) {
            int child = size++;
            int parent = (child - 1) / 2;
            while (child > 0 && offered.val < array[parent].val) {
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = offered;
        }
    
        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }
            swap(0, size - 1);
            size--;
            ListNode e = array[size];
            array[size] = null; // help GC
    
            down(0);
    
            return e;
        }
    
        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left].val < array[min].val) {
                min = left;
            }
            if (right < size && array[right].val < array[min].val) {
                min = right;
            }
            if (min != parent) {
                swap(min, parent);
                down(min);
            }
        }
    
        private void swap(int i, int j) {
            ListNode t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    }

  
}
// @lc code=end

