package com.iaic.problems.puzzle3;
import com.iaic.problems.puzzle3.Puzzle3State;

import aima.search.framework.HeuristicFunction;

public class Puzzle3HeuristicFunction implements HeuristicFunction{
	Puzzle3State _finalState;
	
	public Puzzle3HeuristicFunction(Puzzle3State estadoFinal){
		super();
		this._finalState=estadoFinal;
	}

	public double getHeuristicValue(Object state) {
		Puzzle3State puzzle3State=(Puzzle3State) state;
		int value=0;
		for (int i=1;i<=3;i++){
			value=value+calculateDistance(i,puzzle3State);
		}
		return value;
	}

	public int calculateDistance(int numero,Puzzle3State estado){
		int distanceX=estado.damePosicionX(numero)-_finalState.damePosicionX(numero);
		if (distanceX<0){
			distanceX=-distanceX;
		}
		int distanceY=estado.damePosicionY(numero)-_finalState.damePosicionY(numero);
		if (distanceY<0){
			distanceY=-distanceY;
		}
		return distanceX+distanceY;
	}

}
