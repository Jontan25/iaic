package com.iaic.searchs;

import java.util.List;
import java.util.Vector;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;

public class CycleControlTotalConditionalQueueSearch extends ConditionalQueueSearch {
	private List closed;
	
	public CycleControlTotalConditionalQueueSearch() {
		super();
		closed = new Vector();
	}

	public CycleControlTotalConditionalQueueSearch(ConditionTest conditionTest) {
		super(conditionTest);
		closed = new Vector();
	}


	public void addExpandedNodesToFringe(NodeStore fringe, Node node,
			Problem problem) {
		//Omite el nodo si ya se encuentren en "cerrados"
		if (!(alreadySeen(node))) {
			closed.add(node.getState());
			fringe.add(expandNode(node, problem));

		}
	}

	private boolean alreadySeen(Node node) {
		return closed.contains(node.getState());
	}
}