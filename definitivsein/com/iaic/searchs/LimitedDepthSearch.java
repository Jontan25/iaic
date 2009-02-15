package com.iaic.searchs;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Node;
import aima.search.framework.Problem;
import aima.search.framework.SearchUtils;
import aima.search.uninformed.DepthLimitedSearch;

public class LimitedDepthSearch extends DepthLimitedSearch{
	private static String SEARCH_TIME = "Tiempo de com.iaic.searchs (ns)";
	
	public static final String CORTE="Corte";
	
	private ConditionTest conditionTest;
	long initialTime;
	private final int limit;
	
	public LimitedDepthSearch(int limit,ConditionTest conditionTest) {
		super( limit );
		this.limit = limit;
		this.conditionTest = conditionTest;
	}
	
	public List search(Problem p) throws Exception {
		clearInstrumentation();
		initSearchTime();
		List actions = recursiveDLS(new Node(p.getInitialState()), p, this.limit);
		finishSearchTime( );
		return actions;
	}
	
	private List recursiveDLS(Node node, Problem problem, int limit) {
		boolean cutOffOccured = false;
		if (conditionTest==null || conditionTest.isConditionPassed(node)){
			if (problem.isGoalState(node.getState())) {
				setPathCost(new Double(node.getPathCost()));
				return SearchUtils.actionsFromNodes(node.getPathFromRoot());
			} else if (node.getDepth() == limit) {
				return createCutOffResult();
			} else {
				List children = expandNode(node, problem);
				for (int i = 0; i < children.size(); i++) {
					Node child = (Node) children.get(i);
					List result = recursiveDLS(child, problem, limit);
					if (cutoffResult(result)) {
						cutOffOccured = true;
					} else if (!(failure(result))) {
						return result;
					}
				}
			}	
		}
		if (cutOffOccured) {
			return createCutOffResult();
		} else {
			return new ArrayList();
		}

	}
	
	
	private boolean failure(List result) {

		return result.size() == 0;
	}

	private boolean cutoffResult(List result) {

		return result.size() == 1 && result.get(0).equals(CORTE);
	}

	private List createCutOffResult() {
		List result = new ArrayList();
		result.add(CORTE);
		return result;
	}
	
	private void finishSearchTime() {
		long finalTime=System.nanoTime();
		metrics.set(SEARCH_TIME,finalTime-initialTime);
	}

	private void initSearchTime() {
		initialTime=System.nanoTime();
	}
	
}
