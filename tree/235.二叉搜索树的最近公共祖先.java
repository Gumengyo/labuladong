  /*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while(p.val < a.val && q.val < a.val || a.val < p.val && a.val < q.val){ //在同一侧
            if(p.val < a.val){
                a = a.left;
            }else{
                a = a.right;
            }
    
        }
        return a;
    }
}
// @lc code=end

