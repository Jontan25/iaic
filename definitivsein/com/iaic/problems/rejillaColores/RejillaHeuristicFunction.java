package com.iaic.problems.rejillaColores;

import aima.search.framework.HeuristicFunction;

public class RejillaHeuristicFunction implements HeuristicFunction{	
	//El valor heuristico es la suma de adyacencias de cada una de las casillas entre 2
	//Este valor acaba coincidiendo con el numero de pares adyacentes como lo visto en clase
	public double getHeuristicValue(Object state) {
		EstadoRejilla estadoRejilla=(EstadoRejilla) state;
		int valor=0;
		for (int i=0;i<estadoRejilla.dameTamanoX();i++){
			for (int j=0;j<estadoRejilla.dameTamanoY();j++){
				valor=valor+estadoRejilla.dameNumeroAdyacencias(i,j);
			}
		}		
		return valor/2;
	}	
}
