package com.iaic.searchs;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;
import aima.search.framework.QueueSearch;
import aima.search.framework.SearchUtils;

/**
 * @author Enrique López Mañas
 */

public class ConditionalQueueSearch extends QueueSearch {
	private static String TIEMPO_DE_BUSQUEDA = "Tiempo de com.iaic.searchs (ns)";
	
	public static final String ABIERTOS_VACIO="AbiertosVacio";
	
	ConditionTest conditionTest;
	long initialTime;

	public ConditionalQueueSearch() {
		conditionTest = null;
	}

	public ConditionalQueueSearch(ConditionTest conditionTest) {
		this.conditionTest=conditionTest;
	}

	public List search( Problem problem , NodeStore fringe ) {
		clearInstrumentation();
		this.initSearchTime();
		fringe.add(new Node(problem.getInitialState()));
		setQueueSize(fringe.size());
		while (!(fringe.isEmpty())) {
			Node node = fringe.remove();
			setQueueSize(fringe.size());
			if (conditionTest == null || conditionTest.isConditionPassed(node)){
				if ( problem.isGoalState( node.getState( ) ) ) {
					this.setPathCost( new Double(node.getPathCost()));
					this.finishSearchTime();
					return SearchUtils.actionsFromNodes(node.getPathFromRoot());
				}
				addExpandedNodesToFringe(fringe, node, problem);
				setQueueSize(fringe.size());
			}
		}
		List badResult=new ArrayList();
		badResult.add(ABIERTOS_VACIO);
		return badResult;
	}

	private void finishSearchTime() {
		long finalTime = System.nanoTime();
		metrics.set(TIEMPO_DE_BUSQUEDA,finalTime-initialTime);
	}

	private void initSearchTime() {
		initialTime = System.nanoTime();
	}

	public void addExpandedNodesToFringe(NodeStore fringe, Node node,Problem problem) {
		fringe.add(expandNode(node, problem));
	}

}