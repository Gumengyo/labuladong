/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
// 改动版
// class Solution {
//     public int search(int[] nums, int target) {

//         int low = 0, high = nums.length;
//         while (low < high) {
//             int mid = (low + high) >>> 1;
//             if (target < nums[mid]) {
//                 high = mid;
//             } else if (nums[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 return mid;
//             }
//         }
//         return -1;
//     }
// }
// 平衡版
class Solution {
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length;
        while (1< high - low) {
            int mid = (low + high) >>> 1;
            if(target < nums[mid]){ // 左
                high = mid;
            }else{
                low = mid;
            }
            
        }
        return (nums[low] == target) ? low : -1;
    }
}

// @lc code=end
