import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

    // long prev = Long.MIN_VALUE;

    // 解法1 (中序遍历非递归实现)
    /* 
    public boolean isValidBST(TreeNode node) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode pop = stack.pop();
                // 处理值
                if(prev >= pop.val){
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }
    */

    // 解法2 (中序遍历递归实现)
    /* 
    public boolean isValidBST(TreeNode node){
        if(node == null){
            return true;
        }
        boolean a = isValidBST(node.left);
        if(!a){
            return false;
        }
        // 处理值
        if(prev >= node.val){
            return false;
        }
        prev = node.val;
        return isValidBST(node.right);
    }
    */


    // 解法3 (中序遍历上下限递归)
    public boolean isValidBST(TreeNode node) {
        return doValid(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean doValid(TreeNode node, long min, long max) {

        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }

        return doValid(node.right,node.val,max) && doValid(node.left, min, node.val);
    }
}
// @lc code=end

