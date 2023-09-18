import java.util.*;

/*
 * @lc app=leetc ode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        int[] cache = new int[n + 2];
        Arrays.fill(cache, -1);
        cache[1] = 1;
        cache[2] = 2;

        return f(n, cache);
    }
    
    public static int f(int n, int[] cache) {

        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

}
// @lc code=end

