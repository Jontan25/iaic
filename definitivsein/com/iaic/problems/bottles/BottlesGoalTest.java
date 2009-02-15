/**
 * 
 */
package com.iaic.problems.bottles;

import aima.search.framework.GoalTest;

/**
 * @author Enrique López Mañas
 */

public class BottlesGoalTest implements GoalTest{
	BottlesState _finalState;

	public BottlesGoalTest ( BottlesState finalState ) {
		this._finalState = finalState;
	}
	
	public boolean isGoalState(Object state) {
		BottlesState bottlesState = (BottlesState) state;
		return _finalState.equals( bottlesState );
	}

}
