package heap;
/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for(int i = k;i<nums.length;i++){
            if(nums[i] > heap.peek()){
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }
    
    class MinHeap {
        int[] array;
        int size;
    
        public MinHeap(int capacity) {
            array = new int[capacity];
        }
    
        private void heapify() {
            for (int i = (size >> 1) - 1; i >= 0; i--) {
                down(i);
            }
        }
    
        public int poll() {
            swap(0, size - 1);
            size--;
            down(0);
            return array[size];
        }
    
        public int poll(int index) {
            swap(index, size - 1);
            size--;
            down(index);
            return array[size];
        }
    
        public int peek() {
            return array[0];
        }
    
        public boolean offer(int offered) {
            if (size == array.length) {
                return false;
            }
            up(offered);
            size++;
            return true;
        }
    
        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }
    
        private void up(int offered) {
            int child = size;
            while (child > 0) {
                int parent = (child - 1) >> 1;
                if (offered < array[parent]) {
                    array[child] = array[parent];
                } else {
                    break;
                }
                child = parent;
            }
            array[child] = offered;
        }
    
        private void down(int parent) {
            int left = (parent << 1) + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != parent) {
                swap(min, parent);
                down(min);
            }
        }
    
        // 交换两个索引处的元素
        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
// @lc code=end

