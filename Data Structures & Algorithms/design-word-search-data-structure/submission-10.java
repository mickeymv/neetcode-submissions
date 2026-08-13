class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        
        Node cur = root;
        
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new Node());
            } 
            cur = cur.children.get(ch);
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node curNode) {
        for (int i=index;i<word.length();i++) {
            char ch = word.charAt(i);
            if (ch=='.') {
                for (Node node : curNode.children.values()) {
                    if (search(word, i+1, node)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(!curNode.children.containsKey(ch)) {
                    return false;
                } else {
                    curNode = curNode.children.get(ch);
                }
            }
        }

        return curNode.isWord==true;
    }
}
