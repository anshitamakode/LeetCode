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
    public boolean ans = false;
    public void bst(int k, TreeNode current, TreeNode root){
        if(root == null)
            return;
        if(root.val == k && current != root){
            ans = true;
            return;
        }
        if(root.val > k)
            bst(k, current, root.left);
        else
            bst(k, current, root.right);
    }
    public void inOrder(TreeNode root, TreeNode current, int k){
        if(root == null)
            return;
        inOrder(root.left, current, k);
        bst(k-root.val, root, current);
        inOrder(root.right, current, k);
    }
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root, root, k);
        return ans;
    }
}