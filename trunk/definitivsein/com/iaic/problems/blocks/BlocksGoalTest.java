package com.iaic.problems.blocks;

import aima.search.framework.GoalTest;

/**
 * @author Enrique López Mañas
 */

public class BlocksGoalTest implements GoalTest{

	BlocksState _finalState;
	
	public BlocksGoalTest(BlocksState estadoFinal){
		this._finalState=estadoFinal;
	}
	
	public boolean isGoalState(Object state) {
		BlocksState blocksState= (BlocksState) state;
		return blocksState.getOverA().equals(_finalState.getOverA()) &&
		 blocksState.getOverB().equals(_finalState.getOverB()) &&
		 blocksState.getOverC().equals(_finalState.getOverC());
	}

}
