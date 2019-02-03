/**
 * Implementation of a Doubly Linked List with circular 'sentinel' nodes (nodes at the beginning and end
 * of the DLList which keep track of the front and the back of the list, and which point to each other).
 */
public class DLList {
    /** Nested class to define every node of the DLList */
    public class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;

        public IntNode (int i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public IntNode sentFront;
    public IntNode sentBack;
    public int size;

    public DLList(int x) {
        sentFront = new IntNode(10, null, null);
        sentBack = new IntNode(11, null, null);
        sentFront.next = new IntNode(x, sentFront, sentBack);
        sentBack.prev = sentFront.next;
        sentFront.prev = sentBack;
        sentBack.next = sentFront;
        size = 1;
    }

    /** Creates an empty DLList*/
    public DLList() {
        sentFront = new IntNode(10, null, null);
        sentBack = new IntNode(11, null, null);
        sentFront.prev = sentBack;
        sentFront.next = sentBack;
        sentBack.next = sentFront;
        sentBack.prev = sentFront;
        size = 0;
    }

    /** Add x to the end of the DLList */
    public void addLast(int x) {
        IntNode n = new IntNode(x, null, null);
        sentBack.prev.next = n;
        n.prev = sentBack.prev;
        sentBack.prev = n;
        n.next = sentBack;
        size ++;

    }

    /** Returns the last element of the DLList */
    public int getLast() {
        return sentBack.prev.item;
    }

    /** Add x to the front of the DLList */
    public void addFirst(int x) {
        IntNode n = new IntNode(x, null, null);
        sentFront.next.prev = n;
        n.next = sentFront.next;
        sentFront.next = n;
        n.prev = sentFront;
        size++;
    }

    /** Returns the first element of the DLList */
    public int getFirst() {
        return sentFront.next.item;
    }

    /** Returns a string representation of the DLList */
    public String getString(IntNode n) {
        if (n.equals(sentBack)) {
            return "end";
        }
        return "<"+n.item+", "+getString(n.next)+">";
    }

    /** Prints the string representation of the DLList returned by getString */
    public void print() {
        System.out.print(getString(sentFront.next));
    }

    public static void main(String[] args) {
        /** Testing the methods of the DLList class */
        DLList d = new DLList();
        d.addLast(3);
        d.addFirst(2);
        d.addLast(4);
        d.addFirst(1);
        d.addLast(5);
        System.out.println(d.getFirst()); // Should not be sentFront.item
        System.out.println(d.getLast()); // Should not be sentBack.item
        d.print();
    }
}
