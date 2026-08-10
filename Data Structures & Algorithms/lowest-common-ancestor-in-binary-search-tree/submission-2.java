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
        int val = root.val;
        
        if(val==p.val) {
            return p;
        }
        if(val==q.val) {
            return q;
        }

        if (val<p.val && val<q.val) {
            return lowestCommonAncestor(root.right, p,q);
        }

        if(val>p.val && val>q.val) {
            return lowestCommonAncestor(root.left, p,q);
        }

        return root;
    }
}
