package datastructures;

/**
 * Demonstration of class inheritance using the DLList as a super class.
 * @param <Item>
 */
public class RotatingDLList<Item> extends DLList {
    public void rotateRight() {
        Item item = (Item) removeLast();
        addFirst(item);
    }

    public static void main(String[] args) {
        RotatingDLList r = new RotatingDLList<String>();

        r.addLast("I");
        r.addLast("am");
        r.addLast("a");
        r.addLast("walrus");

        r.rotateRight();
        r.print();

    }
}
