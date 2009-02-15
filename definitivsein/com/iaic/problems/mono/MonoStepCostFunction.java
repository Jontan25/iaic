package com.iaic.problems.mono;

import aima.search.framework.StepCostFunction;

public class MonoStepCostFunction implements StepCostFunction{
	public static final int COSTE_BAJAR=1;
	public static final int COSTE_MOVERSE=2;
	public static final int COSTE_EMPUJAR=3;
	public static final int COSTE_SUBIR=4;
	
	public MonoStepCostFunction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Esta función de coste simula que el realizar un desplazamiento es más dificil en función 
	//de la suciedad de la habitacion y evidentemente lo más costoso es limpiarla (casi imposible :P)
	//Lo menos costoso es bajar de la caja, su valor es 1, 
	//moverse desde un lado a otro de la habitacion tiene valor 2,
	//empujar la caja de un lado a otro de la habitacion tiene valor es 3
	//Lo mas costoso es subirse a la caja tiene un valor 4
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double coste=new Double(0);
		if (action.equals(MonoSuccessorFunction.ACCIONES[0])
			|| action.equals(MonoSuccessorFunction.ACCIONES[1])
			|| action.equals(MonoSuccessorFunction.ACCIONES[2])){
			coste=new Double(COSTE_MOVERSE);		
		}else if (action.equals(MonoSuccessorFunction.ACCIONES[3])
				|| action.equals(MonoSuccessorFunction.ACCIONES[4])
				|| action.equals(MonoSuccessorFunction.ACCIONES[5])){
			coste=new Double(COSTE_EMPUJAR);
		}else if (action.equals(MonoSuccessorFunction.ACCIONES[6])){
			coste=new Double(COSTE_SUBIR);
		}else if (action.equals(MonoSuccessorFunction.ACCIONES[7])){
			coste=new Double(COSTE_BAJAR);
		}
		return coste;
	}
}
