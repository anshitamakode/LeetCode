/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public Map<Integer, Boolean> visited = new HashMap<>();
    public void preorder(TreeNode root, TreeNode par, Map<Integer, TreeNode> map){
        if(root == null)
            return;
        map.put(root.val, par);
        visited.put(root.val, false);
        preorder(root.left, root, map);
        preorder(root.right, root, map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> map = new HashMap<>();
        preorder(root, null, map);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        q.add(null);
        int level = 0;
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 1 && level < k){
            TreeNode front = q.remove();
            if(front != null){
                visited.put(front.val, true);
                if(map.get(front.val) != null && !visited.get(map.get(front.val).val)){
                    q.add(map.get(front.val));
                }
                if(front.left != null && !visited.get(front.left.val)){
                    q.add(front.left);
                }
                if(front.right != null && !visited.get(front.right.val)){
                    q.add(front.right);
                }
            }
            else{
                level++;
                if(level != k)
                    q.add(null);
            }
        }
        while(!q.isEmpty()){
            if(q.peek() != null)
                ans.add(q.peek().val);
            q.remove();
        }
        return ans;
    }
}