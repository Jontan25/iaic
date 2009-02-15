package com.iaic.problems.rejillaColores;

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
public class RejillaGoalTest implements GoalTest{	
	public boolean isGoalState(Object estado) {
		boolean objetivo=false;
		if (estado instanceof EstadoRejilla){
			EstadoRejilla estadoRejilla=(EstadoRejilla) estado;
			objetivo=true;
			int i=0;
			int j;
			while (objetivo && i<estadoRejilla.dameTamanoX()){
				j=0;
				while (objetivo && j<estadoRejilla.dameTamanoY()){
					if (estadoRejilla.dameNumeroAdyacencias(i,j)>0){
						objetivo=false;
					}
					j++;
				}
				i++;
			}
		}
		return objetivo;
	}

}
