/**
 * 
 */
package com.iaic.problems.puzzle8;

import com.iaic.problems.puzzle3.Puzzle3State;
import com.iaic.problems.puzzle8.Puzzle8State;

import aima.search.framework.HeuristicFunction;

/**
 * @author usuario_local
 *
 */
public class Puzzle8HeuristicFunction implements HeuristicFunction{
	Puzzle8State estadoFinal;
	
	public Puzzle8HeuristicFunction(Puzzle8State estadoFinal){
		this.estadoFinal=estadoFinal;		
	}

	public double getHeuristicValue(Object state) {
		Puzzle8State puzzle8State=(Puzzle8State) state;
		int valor=0;
		for (int i=1;i<=8;i++){
			valor=valor+calculaDistancia(i,puzzle8State);
		}
		return valor;
	}
	
	public int calculaDistancia(int numero,Puzzle8State estado){
		int distanciaX=estado.damePosicionX(numero)-estadoFinal.damePosicionX(numero);
		if (distanciaX<0){
			distanciaX=-distanciaX;
		}
		int distanciaY=estado.damePosicionY(numero)-estadoFinal.damePosicionY(numero);
		if (distanciaY<0){
			distanciaY=-distanciaY;
		}
		return distanciaX+distanciaY;
	}
}
