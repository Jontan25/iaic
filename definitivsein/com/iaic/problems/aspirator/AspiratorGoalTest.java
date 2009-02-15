package com.iaic.problems.aspirator;

import aima.search.framework.GoalTest;

/**
 * @author Enrique López Mañas
*/

public class AspiratorGoalTest implements GoalTest{

	AspiratorState _finalState;
	
	/*
	 * Default constructor
	 */
	public AspiratorGoalTest ( AspiratorState finalState ){
		this._finalState = finalState;
	}
	
	/*
	 * Defines if we are in a goal state
	 * @see aima.search.framework.GoalTest#isGoalState(java.lang.Object)
	 */
	public boolean isGoalState(Object state) {
		if ( state instanceof AspiratorState){
			return _finalState.equals(state);
		} else {
			return false;
		}
	}

}
