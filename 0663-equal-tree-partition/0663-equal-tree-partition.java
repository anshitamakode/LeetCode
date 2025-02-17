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
    boolean val = false;
    public boolean checkEqualTree(TreeNode root) {
        int sum = findSum(root);
        if(sum % 2 != 0)
            return false;
        int output = checkEqual(root, sum/2, root);
        return val;
    }
    public int findSum(TreeNode root){
        if(root == null)
            return 0;
        return root.val + findSum(root.left) + findSum(root.right);
    }
    public int checkEqual(TreeNode root, int sum, TreeNode originalRoot){
        if(root == null)
            return 0;
        int ans = root.val + checkEqual(root.left, sum, originalRoot) + checkEqual(root.right, sum, originalRoot);
        if(ans == sum && root != originalRoot){
            val = true;
        }
        return ans;
    }
}