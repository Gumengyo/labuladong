/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    // 方法一 递归
    /* 
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int d1 = minDepth(root.left);
            int d2 = minDepth(root.right);
            if(d1 == 0){ // 当右子树为null
                return d2 + 1; 
            }
            if(d2 == 0){ // 当左子树为null
                return d1 + 1;
            }
            return Integer.min(d1, d2) + 1;
        }
    */

    // 方法二：非递归（层序遍历）
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0;i < size;i++){
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null){
                    return depth;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
// @lc code=end

