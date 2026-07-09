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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }

        TreeNode node = root;

        while(node!=null || !stack.isEmpty()) {
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode current = stack.pop();
            list.add(current.val);
            node = current.right;
        }

        return list;
    }
}