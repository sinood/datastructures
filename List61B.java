package datastructures;

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
}
