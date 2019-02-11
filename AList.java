import datastructures.List61B;

/**
 * Implementation of a resizable ArrayList that takes a generic type.
 */
public class AList<Item> implements List61B<Item> {
    private Item[] items;
    private int firstIndex;
    private int lastIndex;
    private int size;
    private int initialSize = 8;

    /**
     * Creates an empty AList
     */
    public AList() {
        items = (Item[]) new Object[initialSize]; // Arbitrary integer for initial size
        firstIndex = 3;
        lastIndex = 4;
        size = 0;
    }

    /**
     * Creates a deep copy of an AList
     */
    public AList(AList other) {
        int length = other.items.length;
        items = (Item[]) new Object[length];
        System.arraycopy(other.items, 0, items, 0, length);
        firstIndex = other.firstIndex;
        lastIndex = other.lastIndex;
        size = other.size;
    }

    /**
     * Adds item to the front of the AList.
     */
    @Override
    public void addFirst(Item item) {
        /** Resize the AList by a factor of two if the first half of items becomes full */
        items[firstIndex] = item;
        moveFirst(-1);
        size++;
    }

    /**
     * Adds item to the end of the AList.
     */
    @Override
    public void addLast(Item item) {
        /** Resize the AList by a factor of two if the last half of items becomes full */
        items[lastIndex] = item;
        moveLast(1);
        size++;
    }

    /**
     * Removes the first item of the AList and returns it.
     */
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (items.length / size >= 4) {
            resize(items.length / 2);
        }
        Item first = get(0);
        moveFirst(1);
        items[firstIndex] = null; // Get rid of loitering objects!
        size--;
        return first;
    }

    /**
     * Removes the last item of the AList and returns it.
     */
    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length / size >= 4) {
            resize(items.length / 2);
        }
        Item last = get(size - 1);
        moveLast(-1);
        items[lastIndex] = null; // Get rid of loitering objects!
        size--;
        return last;
    }

    /**
     * Moves the first pointer circularly by i
     */
    private void moveFirst(int i) {
        if (i < 0 && firstIndex + i < 0) {
            firstIndex = items.length + (i + firstIndex);
        } else if (i > 0 && firstIndex + i > items.length - 1) {
            firstIndex = i - (items.length - firstIndex);
        } else {
            firstIndex += i;
        }
        if (firstIndex == lastIndex) {
            resize(items.length * 2);
        }
    }

    /**
     * Moves the last pointer circularly by i
     */
    private void moveLast(int i) {
        if (i < 0 && lastIndex + i < 0) {
            lastIndex = items.length + (i + lastIndex);
        } else if (i > 0 && lastIndex + i > items.length - 1) {
            lastIndex = i - (items.length - lastIndex);
        } else {
            lastIndex += i;
        }
        if (firstIndex == lastIndex) {
            resize(items.length * 2);
        }
    }

    /**
     * Returns the item at the given index i.
     */
    @Override
    public Item get(int index) {
        int temp = firstIndex;
        moveFirst(1 + index);
        /*if (newIndex > items.length-1) {
            newIndex -= items.length;
        }*/
        Item item = items[firstIndex];
        firstIndex = temp;
        return item;
    }

    /**
     * Returns the last item in the AList
     */
    @Override
    public Item getLast() {
        int temp = lastIndex;
        moveLast(-1);
        Item item = items[lastIndex];
        lastIndex = temp;
        return item;
    }

    /**
     * Returns the first item in the AList
     */
    @Override
    public Item getFirst() {
        int temp = firstIndex;
        moveFirst(1);
        Item item = items[firstIndex];
        firstIndex = temp;
        return item;
    }


    /**
     * Resizes the AList by resizing the underlying array to size capacity
     */
    private void resize(int capacity) {
        if (capacity < initialSize) {
            return;
        }
        Item[] resized = (Item[]) new Object[capacity];
        if (firstIndex >= lastIndex) {
            System.arraycopy(items, firstIndex, resized, 0, (items.length - firstIndex));
            System.arraycopy(items, 0, resized, (items.length - firstIndex), lastIndex);
            lastIndex += (items.length - firstIndex);
            firstIndex = 0;
        } else {
            System.arraycopy(items, firstIndex, resized, 0, lastIndex - firstIndex);
            lastIndex = lastIndex - firstIndex;
            firstIndex = 0;
        }
        items = resized;
    }

    /**
     * Returns the size of the AList.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the AList is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the AList.
     */
    private String getString() {
        String result = "";
        int temp = firstIndex;
        while (firstIndex != lastIndex - 1 && !(lastIndex == 0 && firstIndex == items.length - 1)) {
            result += get(0) + " ";
            moveFirst(1);
        }
        firstIndex = temp;
        return result;
    }

    /**
     * Prints the string representation of the AList returned by getString.
     */
    public void printDeque() {
        System.out.println(getString());
    }
}

/**
 * Run 'time java SpeedTestAList' in terminal to see how long it takes to add 10 million items to the AList
 */
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