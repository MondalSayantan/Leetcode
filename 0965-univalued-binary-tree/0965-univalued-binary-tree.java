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
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return univalue(root, val);
    }
    
    private static boolean univalue(TreeNode root, int val) {
        if(root == null)
            return true;
        
        if(root.val != val)
            return false;
        
        boolean leftChild = univalue(root.left, val);
        boolean rightChild = univalue(root.right, val);
        
        return leftChild && rightChild;
    }
}