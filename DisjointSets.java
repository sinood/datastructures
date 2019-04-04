package datastructures;

public interface DisjointSets {
    /** Connects g and h. */
    void connect(int g, int h);
    /** Returns whether g and h are connected. */
    boolean isConnected(int g, int h);
}
