package com.iaic.problems.mono;

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
public class MonoGoalTest implements GoalTest{

	EstadoMono estadoFinal;
	
	public MonoGoalTest(EstadoMono estadoFinal){
		this.estadoFinal=estadoFinal;
	}
	
	public boolean isGoalState(Object estado) {
		if (estado instanceof EstadoMono){
			return estadoFinal.equals(estado);
		}else{
			return false;
		}
	}

}
