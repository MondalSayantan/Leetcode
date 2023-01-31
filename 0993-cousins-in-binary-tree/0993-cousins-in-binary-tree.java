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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parents = new int[2];
        int[] levels = new int[2];
        
        // findLevelsAndParents(root, x, y, parents, levels, null, 0);
        findLevelsAndParents(root, x, y, parents, levels, new TreeNode(-1), 0);
        return parents[0] != parents[1] && levels[0] == levels[1];
    }
    
    private static void findLevelsAndParents(TreeNode root, int x, int y, int[] parents, int[] levels, TreeNode currentParent, int currentLevel) {
        
        if(root == null)
            return;
        
        if(root.val == x) {
            parents[0] = currentParent.val;
            levels[0] = currentLevel;
        }
        
        if(root.val == y) {
            parents[1] = currentParent.val;
            levels[1] = currentLevel;
        }
        
        findLevelsAndParents(root.left, x, y, parents, levels, root, currentLevel + 1);
        findLevelsAndParents(root.right, x, y, parents, levels, root, currentLevel + 1);
    }
}