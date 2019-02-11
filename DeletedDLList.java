package datastructures;

/**
 * Implementation of class inheritance and method overriding using DLList as a super class.
 * @param <Item>
 */
public class DeletedDLList<Item> extends DLList {
    DLList<Item> deletedItems;

    public DeletedDLList () {
        deletedItems = new DLList<Item>();
    }

    @Override
    /**
     * Removes the last item of the DeletedDLList, then adds it to deletedItems and returns it.
     */
    public Item removeLast(){
        Item x = (Item) super.removeLast();
        deletedItems.addFirst(x);
        return x;
    }

    public static void main(String[] args) {
        DeletedDLList<String> dd1 = new DeletedDLList<>();

        dd1.addLast("I");
        dd1.addLast("am");
        dd1.addLast("a");
        dd1.addLast("walrus");

        dd1.removeLast();
        dd1.removeLast();
        dd1.print();
        dd1.deletedItems.print();
    }

}
