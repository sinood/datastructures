package datastructures;

import java.util.List;
import java.util.ArrayList;

public class IntGraph {
    private final int V;
    private int edgeCount;
    private List<Integer>[] adjacents;

    /**
     * Constructing an array of v Lists to represent an undirected graph.
     */
    public IntGraph(int v) {
        V = v;
        adjacents = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjacents[i] = new ArrayList<>();
        }
    }

    /**
     * Connects a to b's list of neighbors and vice versa (since this is an
     * undirected graph, edges are represented twice.
     */
    public void addEdge(int a, int b) {
        adjacents[a].add(b);
        adjacents[b].add(a);
        edgeCount++;
    }

    /**
     * Returns a List of the neighbors of v.
     */
    public Iterable<Integer> adjacents(int v) {
        return adjacents[v];
    }

    /**
     * Returns the number of vertices in the IntGraph.
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the IntGraph.
     */
    public int E(){
        return edgeCount;
    }


}
