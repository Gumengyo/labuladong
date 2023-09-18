package array;
import java.util.*;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row, i);
            List<Integer> arrayList = Arrays.stream(row).limit(i+1).boxed().collect(Collectors.toList());
            res.add(arrayList);
        }

        return res;
    }

    private static void createRow(int[] row, int i) {
        if (i == 0) {
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j - 1] + row[j];
        }
    }
    
}
// @lc code=end

