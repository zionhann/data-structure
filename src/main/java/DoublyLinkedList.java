public class DoublyLinkedList {
    static class Node {
        int value;
        Node prev;
        Node next;

        public Node() {
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node curr;

    public DoublyLinkedList() {
        curr = head = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getCurr() {
        return curr;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void push_back(int value) {
        Node temp;

        if (isEmpty()) {
            curr = head = new Node();
        } else {
            curr.next = new Node();
            temp = curr;
            curr = curr.next;
            curr.prev = temp;
        }
        curr.value = value;
    }

    public void push_front(int value) {
        Node nextNode = head;
        Node newNode = head = new Node();

        if (nextNode == null) curr = head;
        else nextNode.prev = newNode;

        newNode.value = value;
        newNode.next = nextNode;

    }

    public void pop_back() {
        curr = curr.prev;

        if (curr == null) head = null;
        else curr.next = null;
    }

    public void pop_front() {
        head = head.next;

        if (isEmpty()) curr = null;
        else head.prev = null;
    }

    public Node search(int target) {
        for (Node p = head; p != null; p = p.next) {
            if (p.value == target) return p;
        }
        return null;
    }

//    public void insert(int targetValue, int value) {
//        Node targetNode = search(targetValue);
//        if (targetNode == null) return;
//
//        Node nextTarget = targetNode.next;
//        Node newNode = targetNode.next = new Node();
//
//        newNode.value = value;
//        newNode.prev = targetNode;
//        newNode.next = nextTarget;
//        nextTarget.prev = newNode;
//    }

    public void insert(int position, int value) {
        Node p = head;
        Node newNode;
        Node nextNode;

        for (int i = 0; i < position; ++i)
            p = p.next;

        if(p.next == null)
            push_back(value);

        else {
            nextNode = p.next;
            p.next = newNode = new Node();
            newNode.prev = p;
            newNode.next = nextNode;
            newNode.value = value;
        }
    }

    public void delete(int position) {
        Node p = head;

        for (int i = 0; i < position; ++i)
            p = p.next;

        if (p.next == null)
            pop_back();

        else if (p.prev == null)
            pop_front();

        else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
    }

    public int getValue(int position) {
        Node p = head;

        for ( int i = 0; i < position; ++i)
            p = p.next;

        return p.value;
    }
}