package com.iaic.problems.aspirator;

import aima.search.framework.HeuristicFunction;

/**
 * @author Enrique López Mañas
*/

public class AspiradorHeuristicFunction implements HeuristicFunction{

	
	private AspiratorState _finalState;
	public AspiradorHeuristicFunction(AspiratorState estadoFinal) {
		super();
		this._finalState=estadoFinal;
	}

	public double getHeuristicValue(Object state) {
		AspiratorState aspiratorState=(AspiratorState) state;
		
		boolean cleanOnLeft = aspiratorState.getLeftCleaning();
		boolean cleanOnCenter = aspiratorState.getMiddleCleaning();
		boolean cleanOnRight = aspiratorState.getRightCleaning();
		int aspiratorPosition = aspiratorState.getAspiratorPositon();
		
		boolean finalCleanOnLeft=_finalState.getLeftCleaning();
		boolean finalCleanOnCenter=_finalState.getMiddleCleaning();
		boolean finalCleanOnRight=_finalState.getRightCleaning();
		int finalAspiratorPosition=_finalState.getAspiratorPositon();
		
		int value = 0;
		if ( finalCleanOnLeft ) {
			if ( !cleanOnLeft ) {
				value =+ AspiradorStepCostFunction.ASPIRATION_COST;
			}
		}
		
		if (finalCleanOnCenter){
			if (!cleanOnCenter){
				value=value+AspiradorStepCostFunction.ASPIRATION_COST;
			}
		}
		
		if ( finalCleanOnRight ){
			if ( !cleanOnRight ){
				value += AspiradorStepCostFunction.ASPIRATION_COST;
			}
		}
		
		int distance = finalAspiratorPosition-aspiratorPosition;
		if ( distance<0 ){
			distance =- 1*distance;
		}
		
		value += distance*AspiradorStepCostFunction.COST_MOVING_FROM_CLEANY;

		return value;
	}

	
}
