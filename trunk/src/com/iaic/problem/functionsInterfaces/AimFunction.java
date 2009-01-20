package com.iaic.problem.functionsInterfaces;
/**
 * 
 * The interface AimFunction represents the different tests that
 * evaluates if, in any state, that's an aim state or not. These
 * test vary with the specific problem, so each problem will have
 * to implement that interface with a state evaluation function.
 * 
 * @authors jose, mario
 *
 */
public interface AimFunction {
	/**
	 * Fuction that will have to be implemented for each specific problem.
	 * @param represents the candidate
	 * @return if the state is an aim state
	 */
	public boolean isAim(Object candidate);
}
