/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import Graph.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Nicole
 */
public class BFS_Solution {
    
    public void BFS(Node s) { //s=source node
        
        //All nodes by default are marked unvisited

        // Create a queue for BFS 
        LinkedList<Node> queue = new LinkedList<Node>();

        // Mark the current node as visited and enqueue it 
        s.visited = true; //visited[s.n]=true; 
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it 
            s = queue.poll();
            System.out.print(s.getLabel() + " ");

            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Edge> i = s.getEdges().listIterator();
            while (i.hasNext()) {
                Node n = i.next().getDestination();
                if (!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }

    }
    
    public void BFS_Search(Node s,Node d) { //s=source , d=destination
        
        //All nodes by default are marked as unvisited

        // Create a queue for BFS 
        LinkedList<Node> queue = new LinkedList<Node>();

        // Mark the current node as visited and enqueue it 
        s.visited = true; //visited[s.n]=true; 
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it 
            s = queue.poll();
            System.out.print(s.getLabel() + " ");
            
            //If destination node is reached, then break from while loop
            if(s.getLabel().contains(d.getLabel())){
                break;
            }
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Edge> i = s.getEdges().listIterator();
            while (i.hasNext()) {
                Node n = i.next().getDestination();
                if (!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
        
    }
}
