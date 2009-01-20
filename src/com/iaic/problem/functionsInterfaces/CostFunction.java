
package com.iaic.problem.functionsInterfaces;

/**
 * The interface CostFunction will be used to represent the different
 * cost or distance functions that will be used. The cost function to
 * change from one state to an other depends on specific problem.
 * @author jose, mario
 *
 */
public interface CostFunction {
	/**
	 * This function will be implemented for each problem.
	 * @param state1 Initial state.
	 * @param state2 Destiny state.
	 * @param operator Applied operator to go from state1 to state2.
	 * @return The cost from state1 to state2 using the indicate operator.
	 */
	public double calculateCost(Object state1,Object state2,String operator);
}
