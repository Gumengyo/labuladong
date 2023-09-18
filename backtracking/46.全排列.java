import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }
    

    void backtrack(int[] nums,LinkedList<Integer> track,boolean[] used){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]){
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
        
    }
}
// @lc code=end

