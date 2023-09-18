/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 前序遍历构造二叉搜索树
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
    // 解法1
    /* 
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            int val = preorder[i];
            insert(root,val);
        }
        return root;
    }
    private TreeNode insert(TreeNode node,int val){
        if(node == null){
            return new TreeNode(val);
        }
        if(val < node.val){
            node.left = insert(node.left, val);
        }else if(node.val < val){
            node.right = insert(node.right, val);
        }
        return node;
    }
    */

    //解法2 上限法
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     return insert(preorder, Integer.MAX_VALUE);
    // }
    // /*
    //  * 依次处理 preorder 中每个值，返回创建好的节点或null
    //  * 1. 如果超过上限，返回null 作为孩子返回
    //  * 2. 如果没超过上限，创建节点，并设置其左右孩子
    //  *      左右孩子完整后返回
    //  */
    // int i = 0;
    // private TreeNode insert(int[] preorder, int max) {

    //     if(i == preorder.length){
    //         return null;
    //     }

    //     int val = preorder[i];
    //     if(val > max){
    //         return null;
    //     }
    //     TreeNode node = new TreeNode(val);
    //     i++;
    //     node.left = insert(preorder, val);
    //     node.right = insert(preorder, max);
    //     return node;
    // }
    

    // 解法3 分治法
    public TreeNode bstFromPreorder(int[] preorder){
        return partition(preorder, 0, preorder.length-1);
    }

    private TreeNode partition(int[] preorder,int start,int end){
        if(start > end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while(index <= end){
            if(preorder[index] > preorder[start]){
                break;
            }
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }
}
// @lc code=end

