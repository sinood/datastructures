/**
 * Implementation of Singly Linked List of integers with 'sentinel' node, which tracks the beginning of the SLList.
 */
public class SLList {
    /**
     * Nested class to define every node of the SLList
     */
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

        /**
         * Return a string representation of the IntNode
         */
        public String getString() {
            if (next == null) {
                return "<" + item + ", null>";
            }
            return "<" + item + ", " + next.getString() + ">";

        }
    }

    public IntNode sentinel; // Every SLList will have an empty first (sentinel) node to avoid null pointer exception
    public int size;

    public SLList(int x) {
        sentinel = new IntNode(10, null); // The integer passed in here is arbitrarily set to 10
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**
     * Creates an empty SLList
     */
    public SLList() {
        sentinel = new IntNode(11, null); // The integer passed in here is arbitrarily set to 11
        size = 0;
    }

    /**
     * Add x to the front of the SLList
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /**
     * Returns the first item in the SLList
     */
    public int getFirst() {
        return sentinel.next.item; // The first item of a SLList will be sentinel.next.item
    }

    /**
     * Add x to the end of the SLList
     */
    public void addLast(int x) {
        IntNode n = sentinel;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new IntNode(x, null);
        size += 1;
    }

    /**
     * Returns the size of the SLList
     */
    public int size() {
        return size;
    }

    /**
     * Print a string representation of the SLList
     */
    public void print() {
        System.out.print(sentinel.next.getString());
    }

    public static void main(String[] args) {
        SLList s = new SLList();
        s.addLast(3);
        s.addFirst(2);
        s.addLast(4);
        s.addFirst(1);
        s.addLast(5);
        s.print();
    }
}

