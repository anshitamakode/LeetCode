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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        int m = inorder.length;
        for(int i=0;i<m;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, n-1, inorder, 0, m-1, map);
        return root;
    }
    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> map){
        if(prestart > preend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = map.get(root.val);
        int preleft = inroot - instart;
        root.left = helper(preorder, prestart+1, prestart+preleft, inorder, instart, inroot-1, map);
        root.right = helper(preorder, prestart+preleft+1, preend, inorder, inroot+1, inend, map);
        return root;
    }
}