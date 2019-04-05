package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class GraphDFSPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public GraphDFSPaths(IntGraph g, int src) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        source = src;
        dfs(g, source);
    }

    /**
     * Depth-first search over the nodes of the IntGraph, populating
     * the marked and edgeTo arrays.
     */
    public void dfs(IntGraph g, int v) {
        if (!marked[v]) {
            marked[v] = true;
            for (int x : g.adjacents(v)) {
                if (!marked[x]) {
                    edgeTo[x] = v;
                    dfs(g, x);
                }
            }
        }
    }

    /**
     * Returns a path (not necessarily the shortest) from source to v as a List.
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = v; i != source; i = edgeTo[i]) {
            result.add(i);
        }
        result.add(source);
        Collections.reverse(result);
        return result;
    }


    /**
     * Returns true if there exists a path from source to v.
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }


    public static void main(String[] args) {
        IntGraph g = new IntGraph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        GraphDFSPaths gdfs = new GraphDFSPaths(g, 0);
        System.out.println(gdfs.pathTo(7));
    }
}
