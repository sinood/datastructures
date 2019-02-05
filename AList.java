/**
 * Implementation of a resizable ArrayList that takes a generic type.
 * */
public class AList<Item> {
    public Item[] items;
    public int size;

    public AList() {
        items = (Item[]) new Object[100]; // Arbitrary initial size
        size = 0;
    }

     //  0 1 2 3 4 5 ...
     // [0 0 0 0 0 0 ...]
     // size = 0
     // =>
     //  0  1 2 3 4 5 ...
     // [4 -2 0 0 0 0 ...]
     // size = 2

    /** Invariants (something that is always true about our datastructure):
     *
     * addLast should add a new int at position size
     * The # of items in the list should be size
     * */
    public void addLast(Item x) {
        /** Resize the AList by a factor of two if  items becomes full */
        if (size == items.length){
            resize(size * 2);
        }
        items[size] = x;
        size ++;
    }

    /** Returns the last item of the AList */
    public int getLast() {
        return items[size-1];
    }

    /** Returns the item at the given index i */
    public int get(Item i) {
        return items[i];
    }

    /** Removes the last item of the AList and returns it */
    public int removeLast(){
        size--;
        return getLast();
    }

    /** Resizes the AList by resizing the underlying array to size capacity */
    private void resize(int capacity) {
        Item[] resized = (Item[]) new Object[capacity];
        System.arraycopy(resized, 0, items, 0, size);
        items = resized;
    }

}

/** Run 'time java SpeedTestAList' in terminal to see how long it takes to add 10 million items to the AList*/
class SpeedTestAList {
    public static void main(String[] args) {
        AList L = new AList();
        int i = 0;
        while (i < 10000000) {
            L.addLast(i);
            i = i + 1;
        }
    }
}