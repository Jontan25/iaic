
package com.iaic.datastructures;

import java.util.Vector;

import com.iaic.problem.Node;

/**
 * @author jose, mario
 *
 */
public class OpenedStack implements OpenedStructure {

	Vector<Node> stack;
	
	public OpenedStack() {
		stack=new Vector<Node>();
		stack.clear();
	}
	
	public boolean add(Node n) {
		stack.insertElementAt(n, 0);
		return true;
	}

	public boolean add(Vector<Node> v) {
		Vector<Node> a=new Vector<Node>();
		a.clear();
		a.addAll(v);
		a.addAll(stack);
		stack=a;
		return true;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public Node extract() {
		return stack.remove(0);
	}

	public int NodesNumber() {
		return stack.size();
	}

}
