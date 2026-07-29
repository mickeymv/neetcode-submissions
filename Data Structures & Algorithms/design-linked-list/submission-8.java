class Node {
    int val;
    Node next;
    Node prev;
}

class MyLinkedList {

    Node head = new Node(),tail= new Node();
    int size =0;
    public MyLinkedList() {
        head.next = tail;
        tail.prev= head;
    }
    
    public int get(int index) {
        int i=0;

        Node node = head.next;

        while(i!=index && node!=tail) {
            node = node.next;
            i++;
        }

        return node==tail? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node();
        node.val = val;

        Node prevHead = head.next;
        node.next=prevHead;
        head.next = node;
        prevHead.prev = node;
        node.prev = head;

        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node();
        node.val = val;

        Node prevTail = tail.prev;
        prevTail.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prevTail;

        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0) {
            addAtHead(val);
        } else if (index==size) {
            addAtTail(val);
        } else if (get(index)==-1) {
            return;
        } else {
            int i=0;

            Node node = head.next;

            while(i!=index && node!=tail) {
                node = node.next;
                i++;
            }

            //node is the node before which we need to add the new value 

            Node newNode = new Node();
            newNode.val = val;

            Node prevNode = node.prev;
            prevNode.next = newNode;
            newNode.next = node;
            node.prev = newNode;
            newNode.prev = prevNode;

            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) {
            return;
        }

        int i=0;

            Node node = head.next;

            while(i!=index && node!=tail) {
                node = node.next;
                i++;
            }

            //node is the node  which we need to delete 

            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode; 

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */