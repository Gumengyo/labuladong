import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if(n.left != null){
                    queue.offer(n.left);
                    c2++;
                }
                if(n.right != null){
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }
    
}
// @lc code=end

