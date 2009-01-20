package com.iaic.problem.functionsInterfaces;

/**
 * The interface HeuristicFunction represent all the heuristics functions,
 * that will be implemented by each problem, adapting it to our estimations.
 * It will be used just in the informed searches. 
 * @author jose, mario
 *
 */
public interface HeuristicFunction {

	/**
	 * @param state The state from witch we ask for the estimation.
	 * @return The estimation of the cost to get an aim state from this state.
	 * 
	 */
	public double heuristicValue(Object state);
}
