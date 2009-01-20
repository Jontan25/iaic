
package com.iaic.datastructures;

import java.util.Vector;
import java.util.Comparator;
import java.util.PriorityQueue;
import com.iaic.problem.Node;

/**
 * It's a priority queue for the expanded nodes but not visited yet.
 * @authors jose, mario
 *
 */
public class OpenedPriorityQueue implements OpenedStructure {

	private PriorityQueue<Node> queue;
	
	
	public OpenedPriorityQueue(Comparator<Node> c) {
		queue=new PriorityQueue<Node>(20,c);
		queue.clear();
	}

	public boolean add(Node n) {
		return queue.add(n);
	}

	public boolean add(Vector<Node> v) {
		return queue.addAll(v);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Node extract() {
		return queue.poll();
	}

	public int NodesNumber() {
		return queue.size();
	}

}
