package array;
import java.util.*;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex+1];
        for (int i = 0; i < rowIndex+1; i++) {
            createRow(row, i);
        }
        return Arrays.stream(row).limit(rowIndex+2).boxed().collect(Collectors.toList());
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

