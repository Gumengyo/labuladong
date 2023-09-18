/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode node, int key) {
        if(node == null){
            return null;
        }
        if(key < node.val){
            node.left = deleteNode(node.left, key);
            return node;
        }
        if(node.val < key){
            node.right = deleteNode(node.right, key);
            return node;
        }
        if(node.left == null){ // 情况1 - 只有右孩子
            return node.right;
        }
        if(node.right == null){ // 情况2 - 只有左孩子
            return node.left;
        }
        TreeNode s = node.right; // 情况3 - 有两个孩子
        while(s.left != null){
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
    }
}
// @lc code=end

