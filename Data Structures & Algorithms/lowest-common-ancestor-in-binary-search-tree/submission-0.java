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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            TreeNode res = root;

            

            return dfs(root,p, q );
        
        
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return root;
        }
        if(p.val>= root.val && q.val<= root.val || p.val<= root.val && q.val>= root.val){
                return root;
        }
        if(p.val> root.val && q.val> root.val){
            return dfs(root.right, p,q);
        }
        if(p.val< root.val && q.val< root.val){
            return dfs(root.left, p,q);
        }
        return null;
        

    }
}
