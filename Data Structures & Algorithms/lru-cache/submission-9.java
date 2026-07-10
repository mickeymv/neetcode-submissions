public class Node {
    int key, val;
    Node left, right;

     public Node(int key, int value) {
        this.key = key;
        this.val = value;
     }
}

class LRUCache {
    int capacity;
    Node lru = new Node(-1, -1);
    Node mru = new Node(-1, -1);
    Map<Integer, Node> keyToNodes = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru.right = mru;
        mru.left = lru;
    }
    
    public int get(int key) {
        if (keyToNodes.containsKey(key)) {
            Node node = keyToNodes.get(key);
            moveNodeToMru(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void moveNodeToMru(Node node) {
        //point the node's left and right to each other 
        node.left.right = node.right;
        node.right.left = node.left;

        addNodeToMru(node);
    }

    private void addNodeToMru(Node node) {
        Node previousMru = mru.left;
        node.right = mru;
        mru.left = node;
        previousMru.right = node;
        node.left = previousMru; 
    }
    
    public void put(int key, int value) {
        if (keyToNodes.containsKey(key)) {
            Node node = keyToNodes.get(key);
            node.val = value;
            moveNodeToMru(node);
        } else {
            if (keyToNodes.size()==capacity) {
                removeLruNode();
            }
            Node node = new Node(key, value);
            addNodeToMru(node);
            keyToNodes.put(key, node);
        }
    }

    private void removeLruNode() {
        Node previousLru = lru.right;
        lru.right = previousLru.right;
        previousLru.right.left=lru;
        keyToNodes.remove(previousLru.key);
    }
}
