package com.iaic.problems.peasant;

import aima.search.framework.StepCostFunction;

public class PeasantStepCostFunction implements StepCostFunction{
	public static final int COSTE_LOBO=4;
	public static final int COSTE_OVEJA=3;
	public static final int COSTE_COL=2;
	public static final int COSTE_GRANJERO=1;
	
	public PeasantStepCostFunction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Esta función de coste simula que el realizar un desplazamiento es más dificil en función de su peso.
	//Lo más facil es mover solo la barca, seguido de mover la col, la oveja, y el lobo
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double coste=new Double(0);
		if (action.equals(PeasantSuccessorFunction.ACCIONES[0])){
			//coste de mover la barca vacia
			coste=new Double(COSTE_GRANJERO);
		}else if (action.equals(PeasantSuccessorFunction.ACCIONES[1])){
			//coste de mover la barca junto al lobo
			coste=new Double(COSTE_LOBO);
		}else if (action.equals(PeasantSuccessorFunction.ACCIONES[2])){
			//coste de mover la barca junto a la oveja
			coste=new Double(COSTE_OVEJA);
		}else if (action.equals(PeasantSuccessorFunction.ACCIONES[3])){
			//coste de mover la barca junto a la col
			coste=new Double(COSTE_COL);
		}
		return coste;
	}
}
