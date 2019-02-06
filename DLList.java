/**
 * Implementation of a Doubly Linked List of a generic type with circular 'sentinel' nodes (nodes at the beginning and end
 * of the DLList which keep track of the front and the back of the list, and which point to each other).
 */
public class DLList<Item> {
    /**
     * Nested class to define every node of the DLList
     */
    public class Node {
        public Item item;
        public Node prev;
        public Node next;

        public Node(Item i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public Node sentFront;
    public Node sentBack;
    public int size;

    public DLList(Item x) {
        /** Initialize sentinel nodes */
        sentFront = new Node(null, null, null);
        sentBack = new Node(null, null, null);
        /** Insert first node in between sentinels */
        sentFront.next = new Node(x, sentFront, sentBack);
        sentBack.prev = sentFront.next;
        /** Make sentinels point to eachother (circular sentinel nodes) */
        sentFront.prev = sentBack;
        sentBack.next = sentFront;
        size = 1;
    }

    /**
     * Creates an empty DLList
     */
    public DLList() {
        sentFront = new Node(null, null, null);
        sentBack = new Node(null, null, null);
        sentFront.prev = sentBack;
        sentFront.next = sentBack;
        sentBack.next = sentFront;
        sentBack.prev = sentFront;
        size = 0;
    }

    /**
     * Add x to the end of the DLList
     */
    public void addLast(Item x) {
        Node n = new Node(x, null, null);
        sentBack.prev.next = n;
        n.prev = sentBack.prev;
        sentBack.prev = n;
        n.next = sentBack;
        size++;

    }

    /**
     * Returns the last element of the DLList
     */
    public Item getLast() {
        return sentBack.prev.item;
    }

    /**
     * Add x to the front of the DLList
     */
    public void addFirst(Item x) {
        Node n = new Node(x, null, null);
        sentFront.next.prev = n;
        n.next = sentFront.next;
        sentFront.next = n;
        n.prev = sentFront;
        size++;
    }

    /**
     * Returns the first element of the DLList
     */
    public Item getFirst() {
        return sentFront.next.item;
    }

    /**
     * Returns a string representation of the DLList
     */
    public String getString(Node n) {
        if (n.equals(sentBack)) {
            return "";
        }
        return "<" + n.item + " " + getString(n.next) + ">";
    }

    /**
     * Prints the string representation of the DLList returned by getString
     */
    public void print() {
        System.out.print(getString(sentFront.next));
    }

    public static void main(String[] args) {
        /** Testing the methods of the DLList class */
        DLList<String> d = new DLList<>();
        d.addLast("you");
        d.addFirst("are");
        d.addLast("doing");
        d.addFirst("how");
        d.addLast("today");
        System.out.println(d.getFirst()); // Should not be sentFront.item
        System.out.println(d.getLast()); // Should not be sentBack.item
        d.print();
    }
}
