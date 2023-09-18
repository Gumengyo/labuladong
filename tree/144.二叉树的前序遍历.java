import java.util.*;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode curr = root; // 代表当前节点
        while (curr != null || !stack.isEmpty()){
            if (curr != null) {
                resultList.add(curr.val);
                stack.push(curr); // 压入栈，为了记住回来的路
                curr = curr.left;
            }else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return resultList;
    }
}
// @lc code=end

