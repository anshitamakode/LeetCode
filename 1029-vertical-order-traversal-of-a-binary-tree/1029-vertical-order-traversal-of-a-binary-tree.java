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
class Pair{
    TreeNode curr;
    int level;
    int height;
    Pair(TreeNode curr, int level, int height){
        this.curr = curr;
        this.level = level;
        this.height = height;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.add(new Pair(root, 0, 0));
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            TreeNode curr = p.curr;
            int level = p.level;
            int height = p.height;
            if(!map.containsKey(height))
                map.put(height, new TreeMap<>());
            if(!map.get(height).containsKey(level))
                map.get(height).put(level, new PriorityQueue<>());
            map.get(height).get(level).add(curr.val);
            if(curr.left != null)
                queue.add(new Pair(curr.left, level+1, height-1));
            if(curr.right != null)
                queue.add(new Pair(curr.right, level+1, height+1));
        }
        for(Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : map.entrySet()){
            int height = entry.getKey();
            Map<Integer, PriorityQueue<Integer>> inner = entry.getValue();
            List<Integer> innerList = new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> entry1 : inner.entrySet()){
                int level = entry1.getKey();
                PriorityQueue<Integer> pq = entry1.getValue();
                while(!pq.isEmpty()){
                    innerList.add(pq.remove());
                }
            }
            ans.add(innerList);
        }
        return ans;
    }
}