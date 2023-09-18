package array;
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = (low+high) >>> 1;
            if(target <= a[mid]){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return low;
    }
}
// @lc code=end

