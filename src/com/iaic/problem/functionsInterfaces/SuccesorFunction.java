
package com.iaic.problem.functionsInterfaces;

import com.iaic.problem.Succesor;

/**
 * The interface SuccesorFunction will be used to represent all
 * the possible functions that will generate the son's nodes in each case.
 * @author jose, mario
 *
 */
public interface SuccesorFunction {
	/**
	 * Generates a list of succesors, result of applying all the possible
	 * operators to the state.
	 * @param state State witch will be applied the operators.
	 * @return List of succesors.
	 */
	public java.util.Vector<Succesor> getSuccesors(Object state);

}
