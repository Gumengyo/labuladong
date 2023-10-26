/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();

        int left = 0 ,right = 0;
        int res = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0) + 1);
            right++;

            while(window.get(c) > 1){
                char d = s.charAt(left);
                window.put(d,window.get(d)-1);
                left++;
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}
// @lc code=end

