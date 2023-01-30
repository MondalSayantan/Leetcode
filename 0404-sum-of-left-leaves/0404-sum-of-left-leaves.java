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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = {0};
        sum(root, ans, false);
        return ans[0];
    }
    
    private static void sum(TreeNode root, int[] ans, boolean isLeft) {
        if(root.left == null && root.right == null){
            if(isLeft)
                ans[0] += root.val;
            return;
        }
        
        if(root.left != null)
            sum(root.left, ans, true);
        if(root.right != null)
            sum(root.right, ans, false);
        
        return;
    }
}