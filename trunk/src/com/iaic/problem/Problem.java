
package com.iaic.problem;
import com.iaic.problem.functionsInterfaces.*;

/**
 * 
 * The Problem class it's going to be used to represent any problem.
 * All the problems will have an initial state, a succesor function, 
 * an aim function that evaluates if a state is an aim state, a cost 
 * function that calculate the cost of going from one state to other
 * state, and a heuristic function to calculate the necessary 
 * estimations in the informed searches.
 * 
 * 
 * @authors jose, mario
 *
 */
public class Problem {
	/**
	 * The initial state for the searches in this problem.
	 */
	Object initialState;
	/**
	 * The succesor function that will be used to generate the result
	 * states of applying each operator.
	 */
	SuccesorFunction funSuccesor;

	AimFunction testAim;

	CostFunction funCost;

	HeuristicFunction funHeuristic;
	
	public Problem() {}
	public Problem(Object e,SuccesorFunction fs,AimFunction fo,CostFunction fc,HeuristicFunction fh) {
		initialState=e;funSuccesor=fs;testAim=fo;funCost=fc;funHeuristic=fh;
	}

	public SuccesorFunction getFunSuccesor() {
		return funSuccesor;
	}

	public CostFunction getFunCost() {
		return funCost;
	}

	public Object getInitialState() {
		return initialState;
	}

	private AimFunction getTestAim() {
		return testAim;
	}
	/**
	 * It evaluates if a state is an aim state using the test.
	 * @param e Candidate state.
	 * @return if it's an aim state.
	 */
	public boolean isAimState(Object e) {
		return getTestAim().isAim(e);
	}

	public HeuristicFunction getFunHeuristic() {
		return funHeuristic;
	}
}
