package datastructures;

/**
 * Interface example, implemented by AList.
 */
public interface List61B<Item> {
    /**
     * Add x to the end of the list
     */
    public void addLast(Item x);

    /**
     * Add x to the front of the list
     */
    public void addFirst(Item x);

    /**
     * Returns the last item of the list
     */
    public Item getLast();

    /**
     * Returns the first item in the list
     */
    public Item getFirst();

    /**
     * Returns the item at the given index i
     */
    public Item get(int i);

    /**
     * Removes the last item of the list and returns it
     */
    public Item removeLast();


    /**
     * Returns the size of the list
     */
    public int size();

    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}

class Demo {
    public static void main(String[] args) {
        AList<String> s = new AList();

        s.addLast("a");
        s.addLast("b");
        s.addLast("c");
        s.addLast("d");
        /* Not defined in AList, uses the implementation inheritance via the default method defined in List61B */
        s.print();
    }

}