import java.util.*;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        boolean odd = true; // 奇数层
        while(!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                if(odd){
                    level.addLast(n.val);
                }else{
                    level.addFirst(n.val);
                }
                if(n.left != null){
                    queue.offer(n.left);
                    c2++;
                }
                if(n.right != null){
                    queue.offer(n.right);
                    c2++;
                }
            }
            odd = !odd;
            result.add(level);
            c1 = c2;
        }
        return result;

    }
}
// @lc code=end

