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

class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _root, int _col, int _row) {
        node = _root;
        row = _row;
        col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        
        queue.add(new Tuple(root, 0, 0));
        
        while(!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            
            TreeNode node = tuple.node;
            int vertical = tuple.col;
            int level = tuple.row;
            
            if(!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());
            
            if(!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new PriorityQueue<>());
            
            map.get(vertical).get(level).add(node.val);
            
            if(node.left != null)
                queue.add(new Tuple(node.left, vertical-1, level+1));
            if(node.right != null)
                queue.add(new Tuple(node.right, vertical+1, level+1));
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tree : map.values()) {
            answer.add(new ArrayList<>());
            
            for(PriorityQueue<Integer> nodes: tree.values()) {
                while(!nodes.isEmpty()) {
                    answer.get(answer.size() - 1).add(nodes.poll());
                }
            }
        }
        
        return answer;
    }
}