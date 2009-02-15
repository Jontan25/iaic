package com.iaic.problems.blocks;

import aima.search.framework.StepCostFunction;

/**
 * @author Enrique López Mañas
 */


public class BlocksStepCostFunction implements StepCostFunction{

	private static final int MAX_ALTURA=3;
	
	public BlocksStepCostFunction() {
		super();
	}
	
	/*
	 * This cost function simulates that performing a movement is more difficult depending on how big is the
	 * difference in the height. Possible values are from 1 to 5. 
	 * 
	 * The easiest is to descend to a table a block from as high as possible (3), the value of this operations is 1
	 * 
	 * The most difficult is to rise a block from a table to the maximum height (3). Cost for this operation is just 1
	 */
	
	public Double calculateStepCost( Object fromState, Object toState, String action ) {
		Double cost = new Double( 0 );
		BlocksState initialState = ( BlocksState ) fromState;
		BlocksState finalState = ( BlocksState ) toState;
		int initialHeight = 0;
		int finalHeight = 0;

		if ( action.equals ( BlocksSuccessorFunction.ACTIONS[0] )
			|| action.equals( BlocksSuccessorFunction.ACTIONS[1] )
			|| action.equals( BlocksSuccessorFunction.ACTIONS[2] ) ){
			initialHeight = initialState.dameAlturaA( );
			finalHeight = finalState.dameAlturaA( );
		} else if ( action.equals ( BlocksSuccessorFunction.ACTIONS[3] )
				|| action.equals( BlocksSuccessorFunction.ACTIONS[4] )
				|| action.equals( BlocksSuccessorFunction.ACTIONS[5] ) ){
				initialHeight = initialState.dameAlturaB( );
				finalHeight = finalState.dameAlturaB( );
			
		} else if ( action.equals ( BlocksSuccessorFunction.ACTIONS[6] )
				|| action.equals ( BlocksSuccessorFunction.ACTIONS[7] )
				|| action.equals ( BlocksSuccessorFunction.ACTIONS[8] ) ){
				initialHeight = initialState.dameAlturaC( );
				finalHeight = finalState.dameAlturaC( );
		}
		
		
		cost = new Double( finalHeight - initialHeight + MAX_ALTURA );
		return cost;
	}
}
