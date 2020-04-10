/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_ex1.pkg2;

import BFS.BFS_Solution;
import Graph.*;
import java.util.ArrayList;

/**
 *
 * @author it21735 , it21754, it21762
 */
public class AI_ex12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Node> myNodes = new ArrayList();

        Node s = new Node(0, "S",4); 
        Node k = new Node(1, "K",5);
        Node l = new Node(2, "L",6);
        Node a = new Node(3, "A",2);
        Node b = new Node(4, "B",3);
        Node c = new Node(5, "C",4);
        Node d = new Node(6, "D",5);
        Node e = new Node(7, "E",6);
        Node f = new Node(8, "F",4);
        Node h = new Node(9, "H",3);
        Node i = new Node(10, "I",2);
        Node j = new Node(11, "J",1);
        Node g = new Node(12, "G",0);

        //Add nodes to myNodes arrayList
        myNodes.add(a);
        myNodes.add(b);
        myNodes.add(c);
        myNodes.add(d);
        myNodes.add(e);
        myNodes.add(f);
        myNodes.add(g);
        myNodes.add(h);
        myNodes.add(i);
        myNodes.add(j);
        myNodes.add(k);
        myNodes.add(l);

        //Create edges
        Edge sa = new Edge(s, a, 2); //S-->A
        Edge sk = new Edge(s, k, 2); //S-->K
        Edge sf = new Edge(s, f, 1); //S-->F
        Edge ab = new Edge(a, b, 2); //A-->B
        Edge bc = new Edge(b, c, 2); //B-->C
        Edge bg = new Edge(b, g, 3); //B-->G
        Edge cd = new Edge(c, d, 2); //C-->D
        Edge de = new Edge(d, e, 1); //D-->E
        Edge dg = new Edge(d, g, 5); //D-->G
        Edge kl = new Edge(k, l, 1); //K-->L
        Edge fh = new Edge(f, h, 1); //F-->H
        Edge hi = new Edge(h, i, 1); //H-->I
        Edge ij = new Edge(i, j, 1); //I-->J
        Edge jg = new Edge(j, g, 1); //J-->G

        //Add edges to nodes
        s.addEdge(sa);
        s.addEdge(sk);
        s.addEdge(sf);

        a.addEdge(ab);

        b.addEdge(bc);
        b.addEdge(bg);

        c.addEdge(cd);

        d.addEdge(de);
        d.addEdge(dg);

        k.addEdge(kl);
        f.addEdge(fh);
        h.addEdge(hi);
        i.addEdge(ij);
        j.addEdge(jg);

        BFS_Solution bfs = new BFS_Solution();

        System.out.println("Following is Best First Search from node S to G ");
        bfs.bestFirstSearch(s,g);

     
    }

}
