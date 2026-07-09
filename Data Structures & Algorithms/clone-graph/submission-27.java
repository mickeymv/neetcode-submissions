/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Map<Node, Node> clones = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if(node==null) {
            return null;
        }

        if(clones.containsKey(node)) {
            return clones.get(node);
        }

        clones.put(node, new Node(node.val));

        ArrayList<Node> neighborClones = new ArrayList<>();

        for(Node neighbor:node.neighbors) {
            neighborClones.add(clone(neighbor));
        }

        clones.get(node).neighbors = neighborClones;

        return clones.get(node);
    }
}