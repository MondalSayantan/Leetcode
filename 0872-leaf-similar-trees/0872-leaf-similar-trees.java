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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        addRootElements(root1, t1);
        addRootElements(root2, t2);
        
        if(t1.equals(t2))
            return true;
        return false;
    }
    
    private static void addRootElements(TreeNode root, ArrayList<Integer> arr) {
        if(root.left == null && root.right == null){
            arr.add(root.val);
            return;
        }
        if(root.left != null)
            addRootElements(root.left, arr);
        if(root.right != null)
            addRootElements(root.right, arr);
        
        return;
    }
}