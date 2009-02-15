package com.iaic.searchs;

import java.util.List;

import aima.search.framework.Node;
import aima.search.framework.Problem;
import aima.search.framework.SearchUtils;
import aima.search.informed.HillClimbingSearch;

public class SimpleClimbingSearch extends HillClimbingSearch{
	private static String TIEMPO_DE_BUSQUEDA = "Tiempo de com.iaic.searchs (ns)";
	private static String PATH_COST = "pathCost";
	
	
	private SearchOutcome outcome = SearchOutcome.FAILURE;

	private Object lastState = null;
	
	private ConditionTest conditionTest;
	long initialTime;
	
	public SimpleClimbingSearch(ConditionTest conditionTest) {
		super();
		this.conditionTest=conditionTest;
	}
	
	public List search(Problem p) throws Exception {
		clearInstrumentation();
		outcome = SearchOutcome.FAILURE;
		lastState = null;
		Node current = new Node(p.getInitialState());
		Node neighbor = null;
		initSearchTime();
		while (conditionTest==null || conditionTest.isConditionPassed(current)){
			List children = expandNode(current, p);
			neighbor = getHigherValuedNodeFrom(current,children, p);

			if (neighbor == null) {
				if (p.isGoalState(current.getState())) {
					outcome = SearchOutcome.SOLUTION_FOUND;
				}
				lastState = current.getState();
				setPathCost(current.getPathCost());
				finalizarTiempoDeBusqueda();
				return SearchUtils.actionsFromNodes(current.getPathFromRoot());
			}else{
				current = neighbor;
			}
		}
		setPathCost(current.getPathCost());
		lastState = current.getState();
		finalizarTiempoDeBusqueda();
		return SearchUtils.actionsFromNodes(current.getPathFromRoot());
	}
	
	public SearchOutcome getOutcome() {
		return outcome;
	}

	public Object getLastSearchState() {
		return lastState;
	}
	
	private Node getHigherValuedNodeFrom(Node node,List children, Problem p) {
		double highestValue = getValue(p,node);
		Node nodeWithHigherValue = null;
		int i = 0;
		while (	nodeWithHigherValue==null && i < children.size()){
			Node child = (Node) children.get(i);
			double value = getValue(p,child);
			if (value > highestValue) {
				nodeWithHigherValue = child;
			}else{
				i++;
			}
		}
		return nodeWithHigherValue;
	}
	
	private double getValue(Problem p, Node n) {
		return -1 * getHeuristic(p, n); // assumption greater heuristic value =>
	}

	private double getHeuristic(Problem p, Node aNode) {
		return p.getHeuristicFunction().getHeuristicValue(aNode.getState());
	}
	
	private void finalizarTiempoDeBusqueda() {
		long finalTime=System.nanoTime();
		metrics.set(TIEMPO_DE_BUSQUEDA,finalTime-initialTime);
	}

	private void initSearchTime() {
		initialTime=System.nanoTime();
	}
	
	public double getPathCost() {
		return metrics.getDouble(PATH_COST);
	}

	public void setPathCost(double pathCost) {
		metrics.set(PATH_COST, pathCost);
	}

}
