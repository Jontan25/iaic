package com.iaic.searchs;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Metrics;
import aima.search.framework.Problem;
import aima.search.uninformed.IterativeDeepeningSearch;

public class IterativeDepthSearch extends IterativeDeepeningSearch{	
	private static String SEARCH_TIME = "Tiempo de com.iaic.searchs (ns)";
	
	private static String PATH_COST = "pathCost";

	public static final String MAXIMUM_ITERATION="IteracionMaxima";
	
	private final int limit;

	private final Metrics iterationMetrics;
	
	private ConditionTest conditionTest;
	long initialTime;
	
	public IterativeDepthSearch() {
		this.limit = Integer.MAX_VALUE;
		iterationMetrics = new Metrics();
		iterationMetrics.set(NODES_EXPANDED, 0);
		iterationMetrics.set(PATH_COST, 0);
	}
	
	public IterativeDepthSearch(ConditionTest conditionTest) {
		super();
		this.limit = Integer.MAX_VALUE;
		iterationMetrics = new Metrics();
		iterationMetrics.set(NODES_EXPANDED, 0);
		iterationMetrics.set(PATH_COST, 0);
		this.conditionTest=conditionTest;
	}

	public List search(Problem p) throws Exception {
		iterationMetrics.set(NODES_EXPANDED, 0);
		iterationMetrics.set(PATH_COST, 0);
		iniciarTiempoDeBusqueda();
		for (int i = 1; i <= limit; i++) {
			LimitedDepthSearch dls = new LimitedDepthSearch(i,conditionTest);
			List result = dls.search(p);
			iterationMetrics.set(NODES_EXPANDED, iterationMetrics
					.getInt(NODES_EXPANDED)
					+ dls.getMetrics().getInt(NODES_EXPANDED));
			// if result != cutoff then return result
			if (!cutOffResult(result)) {
				iterationMetrics.set(PATH_COST, dls.getPathCost());
				finishSearchTime();
				return result;
			}
		}
		List badResult = new ArrayList();
		badResult.add( MAXIMUM_ITERATION );
		finishSearchTime( );
		return badResult;
	}

	
	private boolean cutOffResult(List result) { 
		return result.size() == 1 && result.get(0).equals(LimitedDepthSearch.CORTE);
	}
	
	public Metrics getMetrics() {
		return iterationMetrics;
	}
	
	private void finishSearchTime() {
		long finalTime = System.nanoTime();
		iterationMetrics.set(SEARCH_TIME,finalTime-initialTime);
	}

	private void iniciarTiempoDeBusqueda() {
		initialTime = System.nanoTime();
	}

}
