package datastructures;
import java.util.ArrayDeque;

public class GraphBFSPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;


    public GraphBFSPaths(IntGraph g, int src) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        source = src;
        bfs(g, source);
    }

    /**
     * Breadth-first search over the nodes of the IntGraph, populating
     * the marked and edgeTo arrays.
     */
    public void bfs(IntGraph g, int s){
        ArrayDeque<Integer> fringe = new ArrayDeque<>();
        fringe.add(s);
        marked[s] = true;
        while(!fringe.isEmpty()){
            int v = fringe.removeFirst();
            for(int i : g.adjacents(v)){
                if (!marked[i]){
                    fringe.addLast(i);
                    marked[i] = true;
                    edgeTo[i] = v;
                }
            }
        }
    }

    public static void main(String[] args){

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

        GraphBFSPaths gbfs = new GraphBFSPaths(g, 0);
    }
}
