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
    public TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        helper(root, val);
        if(node != null)
            return node;
        else
            return null;
    }
    public void helper(TreeNode root, int val){
        if(root == null || root.val == val){
            node = root;
            return;
        }
        if(root.val > val)
            helper(root.left, val);
        else
            helper(root.right, val);
    }
}