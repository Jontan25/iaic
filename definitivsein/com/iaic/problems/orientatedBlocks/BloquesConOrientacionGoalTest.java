package com.iaic.problems.orientatedBlocks;

import aima.search.framework.GoalTest;

/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BloquesConOrientacionGoalTest implements GoalTest{

	EstadoBloquesConOrientacion estadoFinal;
	
	public BloquesConOrientacionGoalTest(EstadoBloquesConOrientacion estadoFinal){
		this.estadoFinal=estadoFinal;
	}
	
	public boolean isGoalState(Object estado) {
		EstadoBloquesConOrientacion estadoBloques= (EstadoBloquesConOrientacion) estado;
		return estadoBloques.dameSobreA().equals(estadoFinal.dameSobreA()) &&
			estadoBloques.dameSobreB().equals(estadoFinal.dameSobreB()) &&
			estadoBloques.dameVerticalA()==estadoFinal.dameVerticalA() && 
			estadoBloques.dameVerticalB()==estadoFinal.dameVerticalB();
	}

}
