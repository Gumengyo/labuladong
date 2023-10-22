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
// class Solution {
//     public int search(int[] nums, int target) {

//         int low = 0, high = nums.length;
//         while (1< high - low) {
//             int mid = (low + high) >>> 1;
//             if(target < nums[mid]){ // 左
//                 high = mid;
//             }else{
//                 low = mid;
//             }
            
//         }
//         return (nums[low] == target) ? low : -1;
//     }
// }

// 左侧边界的二分查找
// class Solution {
//     public int search(int[] nums,int target){
//         int left = 0,right = nums.length-1;
//         while(left <= right){
//             int mid = (left+right) >>> 1;
//             if(nums[mid]  < target){
//                 left = mid + 1;
//             }else if(nums[mid] > target){
//                 right = mid -1;
//             }else if(nums[mid] == target){
//                 right = mid -1;
//             }
//         }
//         if(left == nums.length) return -1;
//         return nums[left] == target ? left : -1;
//     }
// }

// 右侧边界的二分查找
class Solution {
    public int search(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left+right) >>> 1;
            if(nums[mid]  < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] == target){
                left = mid +1;
            }
        }
        if(right < 0) return -1;
        return nums[right] == target ? right : -1;
    }
}


// @lc code=end
