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
    public int sumRootToLeaf(TreeNode root) {
        int[] answer = {0};
        sum(root, "" + Integer.toString(root.val), answer);
        return answer[0];
    }
    
    private static void sum(TreeNode root, String currentPath, int[] answer) {
        if(root.left == null && root.right == null) {
            // convert string to decimal and add to answer
            int decimal = Integer.parseInt(currentPath, 2);
            answer[0] += decimal;
            return;
        }
        
        if(root.left != null)
            sum(root.left, currentPath + Integer.toString(root.left.val), answer);
        if(root.right != null)
            sum(root.right, currentPath + Integer.toString(root.right.val), answer);
        
        return;
    }
}