package com.iaic.problems.bottles;

import com.iaic.problems.bottles.BottlesSuccessorFunction;

import aima.search.framework.StepCostFunction;

public class BottlesStepCostFunction implements StepCostFunction{
	public static final int COST_FULFILL_3=3;
	public static final int COST_FULFILL_4=4;
	public static final int COST_EMPTY_3=1;
	public static final int COST_EMPTY_4=1;
	public static final int COST_POUR_3=2;
	public static final int COST_POUR_4=3;
	
	public BottlesStepCostFunction(){
		super();
	}
	
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double cost = null;
		if (action.equals(BottlesSuccessorFunction.ACTIONS[0])){
			cost=new Double(COST_FULFILL_3);
		} else if (action.equals(BottlesSuccessorFunction.ACTIONS[1])){
			cost=new Double(COST_FULFILL_4);
		} else if (action.equals(BottlesSuccessorFunction.ACTIONS[2])){
			cost=new Double(COST_EMPTY_3);
		} else if (action.equals(BottlesSuccessorFunction.ACTIONS[3])){
			cost=new Double(COST_EMPTY_4);
		} else if (action.equals(BottlesSuccessorFunction.ACTIONS[4])){
			cost=new Double(COST_POUR_3);
		} else if (action.equals(BottlesSuccessorFunction.ACTIONS[5])){
			cost=new Double(COST_POUR_4);
		}
		return cost;
	}
	
}
