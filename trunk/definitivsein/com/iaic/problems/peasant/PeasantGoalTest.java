package com.iaic.problems.peasant;

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
public class PeasantGoalTest implements GoalTest{
	PeasantState estadoFinal;
	
	public PeasantGoalTest(PeasantState estadoFinal){
		this.estadoFinal=estadoFinal;
	}

	/* (non-Javadoc)
	 * @see aima.search.framework.GoalTest#isGoalState(java.lang.Object)
	 */

	public boolean isGoalState(Object estado) {
		if (estado instanceof PeasantState){
			return estadoFinal.equals(estado);
		}else{
			return false;
		}
	}
	
}
