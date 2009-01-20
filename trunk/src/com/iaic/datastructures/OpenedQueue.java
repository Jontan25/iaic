/**
 * 
 */
package com.iaic.datastructures;

import java.util.Vector;

import problema.Nodo;

/**
 * Opened nodes queue.
 * @authors jose, mario
 *
 */
public class OpenedQueue implements OpenedStructure {

	Vector<Node> queue;
	
	public OpenedQueue() {
		queue=new Vector<Node>();
		queue.clear();
	}
	
	public boolean add(Node n) {
		queue.add(n);
		return true;
	}

	public boolean add(Vector<Node> v) {
		queue.addAll(v);
		return true;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Node extract() {
		return queue.remove(0);
	}

	public int NodesNumber() {
		return queue.size();
	}

}
