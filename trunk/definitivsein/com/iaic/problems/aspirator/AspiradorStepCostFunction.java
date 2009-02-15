package com.iaic.problems.aspirator;

import aima.search.framework.StepCostFunction;

/**
 * @author Enrique López Mañas
*/

public class AspiradorStepCostFunction implements StepCostFunction{
	public static final int ASPIRATION_COST=3;
	public static final int COST_MOVING_FROM_DIRTY=2;
	public static final int COST_MOVING_FROM_CLEANY=1;
	
	public AspiradorStepCostFunction() {
		super();
		
	}
	
	/*
	 * This cost function simulates that doing a movement is more difficult depending on how dirty a room is,
	 * and obviously the most difficult is to clean it (quite impossible in my particular case)
	 * The less costly is moving from a clean room, the value is 1.
	 * 
	 * Moving from a dirty one has a value of 2
	 * 
	 * And obviously, the most difficult part is cleaning the room, with a value of 3
	 * 
	 * @see aima.search.framework.StepCostFunction#calculateStepCost(java.lang.Object, java.lang.Object, java.lang.String)
	 */
	
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double cost = null;
		AspiratorState initialState = (AspiratorState)fromState;
		
		if ( action.equals( AspiradorSuccessorFunction.ACTIONS[0])){
			cost=new Double(ASPIRATION_COST);		
		}else if (action.equals(AspiradorSuccessorFunction.ACTIONS[1])
				|| action.equals(AspiradorSuccessorFunction.ACTIONS[2])) {
			if (initialState.getAspiratorCleaning()){
				cost=new Double(COST_MOVING_FROM_CLEANY);
			} else {
				cost = new Double(COST_MOVING_FROM_DIRTY);
			}
		}
		return cost;
	}
}
