package stack;
import java.util.List;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
 
        return stack.isEmpty();
    }
}
// @lc code=end

