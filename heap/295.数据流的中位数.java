package heap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {

    // 大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(
        (a,b)-> Integer.compare(b,a));

    // 小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0; 
        }else{
            return left.peek();
        }
    }
  
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

