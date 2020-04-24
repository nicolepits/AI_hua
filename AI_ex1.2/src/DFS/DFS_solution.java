package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Graph.*;

public class DFS_solution { //Recursive DFS

	public DFS_solution(){
	}
	
	public void dfsIterative(Node s) { // Iterative DFS
		// Node s = source
		// stack
		Stack<Node> stack = new Stack<Node>();
		// push source node to the top
		stack.push(s);
		// while stack is not empty
		while (!stack.isEmpty()) {
			Node n = stack.pop(); // remove node that's on top of stack & assign it to node n
			if (!n.visited) {
				System.out.print(n.getLabel() + " ");
				n.visit(); // n.visited = true
			}

			for (int i = 0; i < n.getEdges().size(); i++) { // for every child of node n
				Node next = n.getEdges().get(i).getDestination(); // next child node
				if (next != null && !next.visited) {
					stack.push(next); // push next node to the top of stack
				}
			}
		}
	}

	public void DFS_Search(Node s, Node d) { // Iterative DFS to print path from s(ource) to d(estination)
		System.out.print(s.getLabel() + " ");
		Stack<Node> stack = new Stack<Node>();
		stack.add(s);

		while (!stack.isEmpty()) {
			Node n = stack.pop();
			if (!n.visited) {
				System.out.print(n.getLabel() + " ");
				if (n.getLabel().contains(d.getLabel())) {
					break;
				}
				n.visit();
			}

			for (int i = 0; i < n.getEdges().size(); i++) {
				Node next = n.getEdges().get(i).getDestination();
				if (next != null && !next.visited) {
					stack.add(next);
				}
			}
		}

	}
}