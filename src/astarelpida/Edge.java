/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarelpida;

/**
 *
 * @author it21735 ,  it21754, it21762
 */

public class Edge {

        protected double cost = 0;
        private Node source;
	Node destination;   
	private int weight;    
	
        //Constructor
	public Edge(Node source,Node destination) {
		this.source = source;
		this.destination = destination;
	}    
        
	//Constructor
	public Edge(Node source,Node destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

        //Constructor
        public Edge(double cost, Node source, Node destination, int weight) {
            this.cost = cost;
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    	
	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
        }
}
