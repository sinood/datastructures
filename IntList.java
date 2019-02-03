public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int getSize() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.getSize();
    }

    public int getInt(int i) {
        if (i == 0) {
            return first;
        }
        return rest.getInt(i-1);

    }

    public static void main (String[] args) {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        System.out.println(l.getSize());
        l = new IntList(3, l);
        l = new IntList(4, l);
        l = new IntList(5, l);
        System.out.println(l.getSize());
        System.out.println(l.getInt(3));
    }

}