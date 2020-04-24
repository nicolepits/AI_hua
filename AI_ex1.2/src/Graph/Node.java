/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author it21735 , it21754, it21762
 */
public class Node implements Comparable<Node> {

    public boolean visited;
    public int n;
    public String label;
    public double g_cost;
    public double h_cost;
    public Node parent;
    public List<Edge> edges = new LinkedList<Edge>();

    public double final_cost = 0; // g + n 
    //G(n) the cost of the path from the start node to n 
    //H(n) the heuristic that estimates the cost of the cheapest path from n to goal

    public String toString() {
        return label;
    }

    //Constructor
    public Node() {
    }

    public Node(int n, String label, double h_cost) {
        this.n = n;
        this.label = label;
        this.h_cost = h_cost;
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

    @Override
    public int compareTo(Node o) {
        return Double.compare(o.h_cost, this.h_cost);
    }

}
