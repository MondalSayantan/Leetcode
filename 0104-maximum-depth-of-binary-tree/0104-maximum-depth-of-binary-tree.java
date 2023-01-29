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
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    
    private static int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftAns = 1 + height(root.left);
        int rightAns = 1 + height(root.right);
        
        return Math.max(leftAns, rightAns);
    }
}