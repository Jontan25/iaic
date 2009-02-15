package com.iaic.problems.rejillaColores;

import aima.search.framework.StepCostFunction;

public class RejillaStepCostFunction implements StepCostFunction{
	public static final int COSTE_CAMBIAR=1;
	//Debe tener este coste para que encaje con la heuristica
	
	public RejillaStepCostFunction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Esta función de coste da el mismo valor a cambiar una casilla de un color u otro
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		return new Double(COSTE_CAMBIAR);
	}
}
