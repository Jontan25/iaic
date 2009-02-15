package com.iaic.searchs;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;

/**
 * @author Enrique López Mañas
 */

public class BranchCycleControlConditionalQueueSearch extends ConditionalQueueSearch {
	
	public BranchCycleControlConditionalQueueSearch() {
		super();
	}

	public BranchCycleControlConditionalQueueSearch(ConditionTest conditionTest) {
		super(conditionTest);
	}
	
	public void addExpandedNodesToFringe(NodeStore fringe, Node node,
			Problem problem) {
		if (!(alreadySeen(node))) {
			fringe.add(expandNode(node, problem));
		}
	}

	private boolean alreadySeen(Node node) {
		Object state = node.getState();
		Node compared = node.getParent();
		boolean found = false;
		while ( compared != null && found == false ){
			if ( state.equals ( compared.getState( ) ) ){
				found = true;
			} else {
				compared = compared.getParent( );
			}
		}
		return found;
	}
}