/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        post(root);

        return list;
    }

    private void post(Node node) {
        if (node==null) {
            return;
        }

        for(Node child : node.children) {
            post(child);
        }

        list.add(node.val);

        return;
    }
}