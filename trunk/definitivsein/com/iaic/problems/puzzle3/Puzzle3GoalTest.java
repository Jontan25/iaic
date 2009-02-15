package com.iaic.problems.puzzle3;

import com.iaic.problems.puzzle3.Puzzle3State;

import aima.search.framework.GoalTest;

public class Puzzle3GoalTest  implements GoalTest{
	Puzzle3State estadoFinal;
	
	public Puzzle3GoalTest(Puzzle3State estadoFinal){
		this.estadoFinal=estadoFinal;
	}
	
	public boolean isGoalState(Object estado) {
		Puzzle3State puzzle3State= (Puzzle3State) estado;
		return puzzle3State.equals(estadoFinal);
	}

}