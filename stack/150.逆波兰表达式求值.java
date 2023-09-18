package stack;
import java.util.*;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if ("+-*/".contains(t)) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                switch (t) {
                    case "+" -> {
                        stack.push(a + b);
                    }
                    case "-" -> {
                        stack.push(a - b);
                    }
                    case "*" -> {
                        stack.push(a * b);
                    }
                    case "/" -> {

                        stack.push(a / b);
                    }
                }
            } else { // 数字
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
// @lc code=end
