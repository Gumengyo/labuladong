import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    // 解法1 中序非递归实现
    /* 
    public int rangeSumBST(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack  = new LinkedList<>();
        int sum = 0;
        while(p != null || !stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode pop = stack.pop();
                if(pop.val > high){
                    break;
                }
                // 处理值
                if(pop.val >= low){
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }
    */

    // 解法2 上下限递归
    public int rangeSumBST(TreeNode node, int low, int high) {
        
        if(node == null){
            return 0;
        }

        if(node.val < low){
            return rangeSumBST(node.right, low, high);
        }
        if(node.val > high){
            return rangeSumBST(node.left, low, high);
        }

        // 在范围内
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }
}
// @lc code=end

