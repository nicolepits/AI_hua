package astarelpida;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author it21735 , it21754, it21762
 */
public class Node {

    protected double g_cost;
    protected double h_cost;                                                    //Heuristic cost of the current node 

    protected List<Edge> edges = new LinkedList<>();

    protected Node parent;                                                      //parent node for path 

    protected boolean visited;
    protected int n;
    protected String label;                                                     // node_value

    protected double final_cost = 0; // g + n 
    //G(n) the cost of the path from the start node to n 
    //H(n) the heuristic that estimates the cost of the cheapest path from n to goal

    public String toString() {
        return label;
    }

    //Constructors
    public Node() {
    }

    public Node(String label, double h_cost) {
        this.label = label;
        this.h_cost = h_cost;
    }

    public Node(int n, String label) {
        this.n = n;
        this.label = label;
        this.visited = false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void visit() {
        visited = true;
    }

    public void unvisit() {
        visited = false;
    }

}
