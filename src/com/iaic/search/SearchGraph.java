/**
 * 
 */
package com.iaic.search;

import problem.Node;
import problem.Problem;
import dataStructure.OpenedStructure;
import java.util.HashSet;
import java.util.Vector;
/**
 * This class is more complex than SearchQueue, because add a closed
 * node structure to make cycle control an optimize a bit more the search.
 * We use a hash table to represent the closed structure.
 * @author mario
 */
public class SearchGraph extends SearchQueue {
	
	HashSet<Object> closed;
	
	public SearchGraph() {
		closed=new HashSet<Object>();
		closed.clear();
	}
	/**  
	 * It determines if the state of a node is in the closed structure.
	 * @param n The node.
	 * @return True if the state is in the closed structure.
	 */
	private boolean isinClosed(Node n) {
		return closed.contains(n.getState());
	}

	public void AddandExpand(Problem p, OpenedStructure opened, Node n) {
		if (!isinClosed(n)) {
			closed.add(n.getState());
			Vector<Node> sons=expandNode(n,p);
			opened.add(sons);
		}
	}

	public Vector<String> search(Problem p, OpenedStructure opened) {
		closed.clear();
		return super.search(p, opened);
	}

}
