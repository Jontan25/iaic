package com.iaic.problems.orientatedBlocks;

import aima.search.framework.StepCostFunction;

public class BloquesConOrientacionStepCostFunction implements StepCostFunction{

	public static final int MAX_ALTURA=2;
	
	public BloquesConOrientacionStepCostFunction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Esta función de coste simula que el realizar un desplazamiento es más dificil en función 
	//del cambio de altura (como en el juego de los bloques normal) o del giro realizado, los posibles valores son 1,2,3,4,5,6
	//Lo menos costoso es descender hasta una mesa un bloque desde la máxima altura posible (2) su valor es 1, 
	//mover un bloque a la misma altura tiene valor 2,
	//Casi lo más costoso es subir un bloque desde una mesa hasta la máxima altura posible (2) su valor es 3
	//Lo más costoso es girar un bloque con valor 4
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double coste=new Double(0);
		EstadoBloquesConOrientacion estadoInicial=(EstadoBloquesConOrientacion)fromState;
		EstadoBloquesConOrientacion estadoFinal=(EstadoBloquesConOrientacion)toState;
		int alturaInicial=0;
		int alturaFinal=0;
		if (action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[0])
			|| action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[1])){
			alturaInicial=estadoInicial.dameAlturaA();
			alturaFinal=estadoFinal.dameAlturaA();
			coste=new Double(alturaFinal-alturaInicial+MAX_ALTURA);
		}else if (action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[3])
				|| action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[4])){
				alturaInicial=estadoInicial.dameAlturaB();
				alturaFinal=estadoFinal.dameAlturaB();
				coste=new Double(alturaFinal-alturaInicial+MAX_ALTURA);
		}else if (action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[2])
				|| action.equals(BloquesConOrientacionSuccessorFunction.ACCIONES[5])){
			//Los giros tienen el coste maximo	
			coste=new Double(2*MAX_ALTURA);
		}
		return coste;
	}
}
