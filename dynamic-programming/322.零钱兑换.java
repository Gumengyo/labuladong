import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {

    // int[] memo;

    // public int coinChange(int[] coins, int amount) {
    //     memo = new int[amount + 1];
    //     // 备忘录 初始化为一个不会被取到的特殊值，代表还未被计算
    //     Arrays.fill(memo, -666);
    //     return dp(coins,amount);
    // }
    // // 定义：要凑出金额 n ，至少要 dp(coins,n) 个硬币
    // int dp(int[] coins,int amount){
    //     if(amount == 0 ) return 0;
    //     if(amount < 0) return -1;
    //     // 查备忘录，防止重复计算
    //     if(memo[amount] != -666)
    //         return memo[amount];

    //     int res = Integer.MAX_VALUE;
    //     for (int coin: coins){
    //         // 计算子问题的结果
    //         int subProblem = dp(coins,amount - coin);
    //         // 子问题无解则跳过
    //         if (subProblem == -1) continue;
    //         // 在子问题中选择最优解，然后加 1
    //         res = Math.min(res, subProblem + 1);
    //     }
    //     // 把计算结果存入备忘录
    //     memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    //     return memo[amount];
    // }

    // dp 数组迭代
    int coinChange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        // 数字大小为amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin:coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1:dp[amount];
    }
}
// @lc code=end

