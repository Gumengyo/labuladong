/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 
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
    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private static void fn(TreeNode node) {

        if(node == null){
            return;
        }

        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        
        fn(node.left);
        fn(node.right);
    }
}
// @lc code=end

