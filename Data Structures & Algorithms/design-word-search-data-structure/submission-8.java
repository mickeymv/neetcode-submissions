class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Node());
            } 
            node = node.children.get(ch);
        }
        node.isWord=true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        for (int i=index;i<word.length();i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Node child : node.children.values()) {
                    if(search(child, word, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    return false;
                }
            }
        }

        return node.isWord == true;
    }
}
