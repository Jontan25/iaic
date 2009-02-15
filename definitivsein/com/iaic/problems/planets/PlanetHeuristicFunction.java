package com.iaic.problems.planets;


import aima.search.framework.HeuristicFunction;

public class PlanetHeuristicFunction implements HeuristicFunction{
	public static final String DESCRIPCION="Distancia Planetaria - Suma de los movimientos necesarios en eje X, en el eje Y y en el eje Z del laberinto";
	
	public PlanetHeuristicFunction() {
		super();
		
	}

	public double getHeuristicValue(Object state) {
		return 2.0;
	}
}
