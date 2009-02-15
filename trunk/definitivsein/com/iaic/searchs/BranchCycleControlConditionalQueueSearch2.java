package com.iaic.searchs;

import java.util.List;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;

/**
 * @author Enrique López Mañas
 */


public class BranchCycleControlConditionalQueueSearch2 extends ConditionalQueueSearch {
	public BranchCycleControlConditionalQueueSearch2() {
		super();
	}

	public BranchCycleControlConditionalQueueSearch2(ConditionTest conditionTest) {
		super(conditionTest);
	}
	
	public void addExpandedNodesToFringe(NodeStore fringe, Node node, Problem problem) {
		List expanded = expandNode(node, problem);
		int numExpanded = expanded.size();
		Node actual;
		for (int i=0;i<numExpanded;i++){
			actual = (Node)expanded.get( i );
			if (!alreadySeen( actual )){
				fringe.add( actual );
			}
		}
	}

	private boolean alreadySeen( Node node ) {
		Object state = node.getState( );
		Node compared = node.getParent( );
		boolean found = false;
		while ( compared != null && found == false){
			if ( state.equals ( compared.getState( ) ) ) {
				found = true;
			} else {
				compared = compared.getParent( ) ;
			}
		}
		return found;
	}
}