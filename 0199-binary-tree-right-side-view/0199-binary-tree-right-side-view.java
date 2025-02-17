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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> inner = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr == null){
                outer.add(inner);
                inner = new ArrayList<>();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            inner.add(curr.val);
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        for(List<Integer> list : outer){
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
}