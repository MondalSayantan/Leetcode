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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return isSum(root, targetSum);
    }
    
    private static boolean isSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null) {
            targetSum -= root.val;
            if(targetSum == 0)
                return true;
            return false;
        }
        
        boolean ans = false;
        
        ans = ans || isSum(root.left, targetSum - root.val);
        ans = ans || isSum(root.right, targetSum - root.val);
        
        return ans;
    }
}