import java.util.*;

import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    // 方法一 递归 分解问题计算
    /*
        public int maxDepth(TreeNode node) {

            if(node == null){
                return 0;
            }

            int d1 = maxDepth(node.left);
            int d2 = maxDepth(node.right);
            return Integer.max(d1, d2) + 1;

        }
    */

    // 方法二 非递归(后序遍历)
    /* 
    public  int maxDepth(TreeNode root){
        TreeNode curr = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0; // 栈最大高度
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                int size = stack.size();
                if(size > max){
                    max = size;
                }
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                }else{
                    curr = peek.right;
                }
            }
        }
        return max;
    }
    */

    // 方法三 非递归（层序遍历)
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode poll = queue.poll();
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

