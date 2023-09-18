import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 记录最近一次出栈元素
        while (curr != null || !stack.isEmpty()){
            if (curr != null) {
                stack.push(curr); // 压入栈，为了记住回来的路
                curr = curr.left;
            }else {
                TreeNode peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                    resultList.add(pop.val);
                }else{
                    curr = peek.right;
                }
            }
        }
        return resultList;
    }
}
// @lc code=end

