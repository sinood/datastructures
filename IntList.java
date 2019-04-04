/**
 * 'Naked' IntList liked list datastructure. Minimal functionality.
 */
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
        return rest.getInt(i - 1);

    }

    public static void main(String[] args) {
        IntList l = new IntList(7, null);
        l = new IntList(6, l);
        System.out.println(l.getSize());
        l = new IntList(5, l);
        l = new IntList(4, l);
        l = new IntList(3, l);
        System.out.println(l.getSize());
        System.out.println(l.getInt(3));


        l = new IntList(2, l);

        l = new IntList(1, l);
        System.out.println(l.getString());

        IntList[] R = new IntList[6];
        tri(R, l);
        for (int i = 0; i < R.length; i++){

            System.out.println(R[i].getString());
        }
    }

    /**
     * Return a string representation of the IntNode
     */
    public String getString() {
        if (rest == null) {
            return first + "";
        }
        return first + " " + rest.getString();

    }

    public static void tri(IntList[] R, IntList L) {
        for (int k =0; k < R.length; k++){
            R[k] = L;
            for (int i = 0; i < k+1; i++) {
                if (L == null) {
                    return;
                }
                if (i == k) {
                    IntList temp = L.rest;
                    L.rest = null;
                    L = temp;
                } else {
                    L = L.rest;
                }
            }
        }
    }


}