/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if(node == null){
           return new TreeNode(val);
        }
        if(val < node.val){
           node.left = insertIntoBST(node.left, val);
        }else if(node.val < val){
           node.right = insertIntoBST(node.right, val);
        }
        return node;
    }
}
// @lc code=end

