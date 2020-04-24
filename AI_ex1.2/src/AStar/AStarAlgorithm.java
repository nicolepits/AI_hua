/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

import java.util.*;
import Graph.*;
/**
 *
 * @author it21735 , it21754, it21762
 */
public class AStarAlgorithm {
    
    public AStarAlgorithm() {  //constructor 

    }


    public static void AstarSearch(Node source, Node goal) {                 //FINDS THE PATH BASED ON THE A STAR ALGORITHM 
        List<Node> explored_nodes = new ArrayList<>();                          //closed list 
        ArrayList<Node> open = new ArrayList<>();                               //open list , nodes about to be explored 

        source.g_cost = 0;                                                      //cost from start
        open.add(source);                                                       //add then source node into the list 

        boolean found = false;

        AStarAlgorithm a1 = new AStarAlgorithm();
        while ((!open.isEmpty()) && (!found)) {                                 //while the open list is not empty and one or more node found => found = true 

            a1.swap(open);                                                      //SWAP  IF THERE IS MORE THAN ONE ELEMENTS IN THE OPEN LIST , so that the first node in the will have the lowest f

            Node current = open.get(0);                                         // GET THE FIRST OF THE LIST which has the lowest f , copy to explored and then delete from open 
            System.out.println(" current=  " + current);

            explored_nodes.add(current);

            open.remove(0);
            
            if (current.label.equals(goal.label)) {                             //if G = G, goal found, if the retrieved from open list node is the same with 

                System.out.println("GOAL NODE FOUND");
                found = true;
            }

            //check every child of current node
            //the current node is being connected with other nodes through edges 
            if ( !(current.edges.isEmpty()) ){
                for (Edge e : current.edges) {                                  //for every AKMH that the current node has 

                    Node child = e.destination;                                 //child = the node that the edge results in 
                    double edge_cost = e.cost;                                  //the cost of the edge 
                    double temp_g_scores = current.g_cost + edge_cost;
                    double temp_f_scores = temp_g_scores + child.h_cost;

                    if ((explored_nodes.contains(child)) && (temp_f_scores >= child.final_cost)) {    //if child node has been evaluated and the newer f_score is higher, skip
                        continue;
                    } else if ((!open.contains(child)) || (temp_f_scores < child.final_cost)) {           //if child node has not been evaluated( does not exist in open list ) and the newer f_score is lower

                        child.parent = current;
                        //costs from current to the child 
                        child.g_cost = temp_g_scores;
                        child.final_cost = temp_f_scores;

                        if (!(open.contains(child))) {
                            open.add(child);
                        }
                    }
                }
            }
        }
    }

    public static List<Node> printPath(Node target) {  //prints the path from source node to destination node 

        List<Node> path = new ArrayList<>();

        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    protected void swap(ArrayList<Node> open) {
        //Every time I add a new node to the arraylist, the one with the lowest f has to be in the first poistion of the list!!!
        //SWAP ONLY IF THERE IS MORE THAN ONE ELEMENTS IN THE OPEN LIST,
        if (open.size() >= 2) {                                                 //check IF THERE IS MORE THAN ONE ELEMENTS IN THE OPEN LIST => in order no to get error: index out of bound 

            //move the node with the lowest f_cost of the open list to the explored/closed list 
            int current_position1 = open.size() - 1;                            //last position is the position where current node was just added
            int pos_index1 = current_position1 - 1;                             //open.size()-2;

            //NODES 
            Node current_node1 = null;
            Node pos_index_node1 = null;

            pos_index_node1 = open.get(pos_index1);
            current_node1 = open.get(current_position1);

            while (current_node1.final_cost < pos_index_node1.final_cost) {  //compare with the previous one
                //swap 
                open.set(pos_index1, current_node1);
                open.set(current_position1, pos_index_node1);

                AStarAlgorithm a = new AStarAlgorithm();
                if (a.isSorted(open) == true) {
                    break;
                }
                current_position1 = current_position1 - 1;
                pos_index1 = pos_index1 - 1;
            }
        }
    }

    protected boolean isSorted(ArrayList<Node> open) {                           //check if the arraylist is ascending
        boolean ascending = false;
        for (int i = 0; i < open.size() - 1; i++) {
            if (open.get(i).final_cost < open.get(i + 1).final_cost) {
                ascending = true;
            } else {
                ascending = false;
            }
        }
        return ascending;
    }
}