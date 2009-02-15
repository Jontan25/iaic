/**
 * 
 */
package com.iaic.problems.puzzle8;

import com.iaic.problems.puzzle8.Puzzle8SuccessorFunction;

import aima.search.framework.StepCostFunction;

/**
 * @author usuario_local
 *
 */
public class Puzzle8StepCostFunction implements StepCostFunction{
	
	public Puzzle8StepCostFunction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Esta funci�n de coste simula que el realizar un desplazamiento es m�s dificil en funci�n de su peso.
	//Lo m�s facil es mover solo la barca, seguido de mover la col, la oveja, y el lobo
	public Double calculateStepCost(Object fromState, Object toState, String action) {
		Double coste=new Double(0);
		if (action.equals(Puzzle8SuccessorFunction.ACCIONES[0])){
			coste=new Double(1);
		}else if (action.equals(Puzzle8SuccessorFunction.ACCIONES[1])){
			coste=new Double(1);
		}else if (action.equals(Puzzle8SuccessorFunction.ACCIONES[2])){
			coste=new Double(1);
		}else if (action.equals(Puzzle8SuccessorFunction.ACCIONES[3])){
			coste=new Double(1);
		}
		return coste;
	}
}
