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
        public double h_cost;   
	private List<Edge> edges = new LinkedList<Edge>();
	
	//Constructor
	public Node() {
	}
	
	public Node(int n,String label,double h_cost) {
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
        return Double.compare(o.h_cost,this.h_cost);
    }

  
}
