import java.util.*;
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // todo: 待优化 
        if(postorder.length == 0){
            return null;
        }
        // 创建根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 0 ~ i-1 左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                
                // i+1 ~ inorder.length - 1 右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder,i,postorder.length - 1);

                root.left = buildTree(inLeft,postLeft );
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
// @lc code=end

