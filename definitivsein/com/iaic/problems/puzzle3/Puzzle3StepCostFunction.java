package com.iaic.problems.puzzle3;

import com.iaic.problems.puzzle3.Puzzle3SuccessorFunction;

import aima.search.framework.StepCostFunction;

public class Puzzle3StepCostFunction implements StepCostFunction{
	
	public Puzzle3StepCostFunction() {
		super();
	}
	
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double coste=new Double(0);
		if (action.equals(Puzzle3SuccessorFunction.ACCIONES[0])){
			coste=new Double(1);
		}else if (action.equals(Puzzle3SuccessorFunction.ACCIONES[1])){
			coste=new Double(1);
		}else if (action.equals(Puzzle3SuccessorFunction.ACCIONES[2])){
			coste=new Double(1);
		}else if (action.equals(Puzzle3SuccessorFunction.ACCIONES[3])){
			coste=new Double(1);
		}
		return coste;
	}

}
