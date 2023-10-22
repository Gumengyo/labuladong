/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    // public int[] searchRange(int[] a, int target) {
    //     int x = left(a, target);
    //     if(x == -1){
    //         return new int[]{-1,-1};
    //     }else{
    //         return new int[]{x,right(a, target)};
    //     }
    // }

    // public static int left(int[] a, int target) {
    //     int i = 0, j = a.length - 1;
    //     int candidate = -1;
    //     while(i <= j){
    //         int m = (i+j) >>> 1;
    //         if(target < a[m]){
    //             j = m - 1;
    //         }else if(a[m] < target){
    //             i = m + 1;
    //         }else{
    //             candidate = m;
    //             j = m - 1;
    //         }
    //     }
    //     return candidate;
    // }

    // public static int right(int[] a, int target) {
    //     int i = 0, j = a.length - 1;
    //     int candidate = -1;
    //     while(i <= j){
    //         int m = (i+j) >>> 1;
    //         if(target < a[m]){
    //             j = m - 1;
    //         }else if(a[m] < target){
    //             i = m + 1;
    //         }else{
    //             candidate = m;
    //             i = m + 1;
    //         }
    //     }
    //     return candidate;
    // }

    public int[] searchRange(int[] a, int target) {
        int x = left_bound(a, target);
        if(x == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{x,right_bound(a, target)};
        }
    }

    public static int left_bound(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left+right) >>> 1;
            if(nums[mid]  < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] == target){
                right = mid - 1;
            }
        }
        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    public static int right_bound(int[] nums,int target){
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
