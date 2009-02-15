package com.iaic.searchs;

import java.util.List;
import java.util.Vector;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;

public class ControlDeCiclosTotalCondicionalQueueSearch2 extends ConditionalQueueSearch {
	private List closed;
	
	public ControlDeCiclosTotalCondicionalQueueSearch2() {
		super();
		closed = new Vector();
	}

	public ControlDeCiclosTotalCondicionalQueueSearch2(ConditionTest conditionTest) {
		super(conditionTest);
		closed = new Vector();
	}


	public void addExpandedNodesToFringe(NodeStore fringe, Node node,
			Problem problem) {
		// if STATE[node] is not in closed then
		closed.add(node.getState());
		List expandidos=expandNode(node, problem);
		int numExpandidos=expandidos.size();
		Node actual;
		//No incluye los hijos del nodo si ya se encuentran en cerrados
		for (int i=0;i<numExpandidos;i++){
			actual=(Node)expandidos.get(i);
			if (!alreadySeen(actual)){
				fringe.add(actual);
			}
		}
	}

	private boolean alreadySeen(Node node) {
		return closed.contains(node.getState());
	}
}