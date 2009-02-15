package com.iaic.problems.orientatedBlocks;

import aima.search.framework.HeuristicFunction;

public class BloquesConOrientacionHeuristicFunction implements HeuristicFunction{

	
	private EstadoBloquesConOrientacion estadoFinal;
	
	public BloquesConOrientacionHeuristicFunction(EstadoBloquesConOrientacion estadoFinal) {
		super();
		this.estadoFinal=estadoFinal;
	}

	public double getHeuristicValue(Object state) {
		EstadoBloquesConOrientacion estadoBloques=(EstadoBloquesConOrientacion) state;
		String mesaActualA=estadoBloques.dameMesa(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[0]);
		String mesaActualB=estadoBloques.dameMesa(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[1]);
		boolean verticalActualA=estadoBloques.dameVerticalA();
		boolean verticalActualB=estadoBloques.dameVerticalB();
		int alturaActualA=estadoBloques.dameAlturaA();
		int alturaActualB=estadoBloques.dameAlturaB();
		
		String mesaFinalA=estadoFinal.dameMesa(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[0]);
		String mesaFinalB=estadoFinal.dameMesa(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[1]);
		boolean verticalFinalA=estadoFinal.dameVerticalA();
		boolean verticalFinalB=estadoFinal.dameVerticalB();
		int alturaFinalA=estadoFinal.dameAlturaA();
		int alturaFinalB=estadoFinal.dameAlturaB();
		
		int valor=0;
		if (mesaActualA.equals(mesaFinalA)){
			//Si un bloque esta en la misma mesa que su solucion
			if (alturaActualA!=alturaFinalA){
				//Pero no esta en la altura correspondiente por lo menos será necesario moverlo 2 veces
				valor=valor+2;
			}
		}else{
			//Si no esta en la mesa por lo menos será necesario moverlo una vez
			valor++;
		}

		//Si no esta en su orientacion por lo menos habrá que girarlo una vez
		if (verticalActualA==verticalFinalA){
			valor=valor+BloquesConOrientacionStepCostFunction.MAX_ALTURA;
		}
		
		//Para el resto de los bloques se actual igual
		if (mesaActualB.equals(mesaFinalB)){
			if (alturaActualB!=alturaFinalB){
				valor=valor+2;
			}
		}else{
			valor++;
		}
		if (verticalActualB==verticalFinalB){
			valor=valor+BloquesConOrientacionStepCostFunction.MAX_ALTURA;
		}
		
		return valor;
	}

	
}
