/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    // 方法1 暴力递归 栈溢出 
    // public int fib(int n) {
    //     if (n == 1 ||n == 2) return 1;
    //     return fib(n-1) + fib(n-2);
    // }

    // 方法2 带备忘录的递归
    // public int fib(int n) {
    //     // 备忘录全初始化为0
    //     int[] memo = new int[n+1];
    //     // 进行带备忘录的递归
    //     return helper(memo,n);
    // } 
    // int helper(int[] memo,int n){
    //     if(n==0 || n==1) return n;
    //     if(memo[n] != 0) return memo[n];
    //     memo[n] = helper(memo, n-1)+helper(memo, n-2);
    //     return memo[n];
    // }

    // 方法3 dp 数组迭代
    public int fib(int n){
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end           

