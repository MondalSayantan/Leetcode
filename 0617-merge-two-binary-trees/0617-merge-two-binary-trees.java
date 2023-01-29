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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }
    
    private static TreeNode merge(TreeNode t1, TreeNode t2) {
        // if(t1 == null && t2 == null)
        //     return null;                         // Not Necessary
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = merge(t1.left, t2.left);
        newNode.right = merge(t1.right, t2.right);
        
        return newNode;
    }
}