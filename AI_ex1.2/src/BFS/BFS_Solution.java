/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import Graph.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author it21735 , it21754, it21762
 */
public class BFS_Solution {

    private PriorityQueue<Node> queue = new PriorityQueue<Node>();

    public void bestFirstSearch(Node source,Node destination) {

        Node evaluationNode;
        queue.add(source);
        
        while (!queue.isEmpty()) {
           
            System.out.println();
            System.out.println("Queue contains:");
            for(Node n: queue){
                System.out.print(n.label + ",");
            }
            System.out.println();
            
            evaluationNode = queue.poll();
            System.out.print("We remove node " + evaluationNode.getLabel() + "\t");
            
            //Create a list of evaluation's Node's edges and keep the neighbours
            List<Edge> myEdges = new LinkedList<Edge>();
            myEdges = evaluationNode.getEdges();
            List<Node> myNodes = new LinkedList<Node>();
            
            
            //Append all neighbor Nodes to a list
            for( Edge edges : myEdges){
                
                myNodes.add(edges.getDestination());
                
            }
            
            boolean check = false;
            
            //if destination node is one of the neighbours, then break from while loop
            for(Node node : myNodes){
                
                if(node.getLabel().contains(destination.getLabel())){
                    
                    check = true;
                    System.out.println();
                    System.out.println("Destination node " + node.getLabel() +" found!");
                    break;
                    
                }
            }
            
            if(check){
                break;
            }
            
            //for loop to examine all evaluationNode's neighbors
            for(Node node: myNodes){
                if(!node.visited){
                    node.visited = true;
                    queue.add(node);
                }   
            }
            
            //mark evaluationNode examined;
            evaluationNode.visited = true;
        }
        
    }

  
}
