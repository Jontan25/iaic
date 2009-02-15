package com.iaic.problems.aspirator;
import java.util.List;
import java.util.Vector;

import com.iaic.problems.bottles.BottlesStepCostFunction;



import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/**
 * @author Enrique López Mañas
 *
 */
public class AspiradorSuccessorFunction implements SuccessorFunction{
	 
	
	public static String[] ACTIONS={"aspirar ("+AspiradorStepCostFunction.ASPIRATION_COST+")",
									"izquierda (variable)",
									"derecha (variable)",
									};
	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	public List getSuccessors(Object state) {
		List movements = new Vector();
		AspiratorState aspiratorState = (AspiratorState) state;
		AspiratorState newState;
		
		int posicionAspirador = aspiratorState.getAspiratorPositon();
		boolean leftCleaning = aspiratorState.getLeftCleaning();
		boolean centerCleaning = aspiratorState.getMiddleCleaning();
		boolean rightCleaning = aspiratorState.getRightCleaning();
		
		
		//Only if the top is a block will be moved to a different position
		if (!aspiratorState.getAspiratorCleaning()){
			if (posicionAspirador==AspiratorState.LEFT){
				newState=new AspiratorState(posicionAspirador,true,centerCleaning,rightCleaning);
			}else if (posicionAspirador==AspiratorState.RIGHT){
				newState=new AspiratorState(posicionAspirador,leftCleaning,centerCleaning,true);
			}else{
				newState=new AspiratorState(posicionAspirador,leftCleaning,true,rightCleaning);
			}
			movements.add(new Successor(ACTIONS[0],newState));
		}
		if (posicionAspirador>AspiratorState.LEFT){
			newState=new AspiratorState(posicionAspirador-1,leftCleaning,centerCleaning,rightCleaning);
			movements.add(new Successor(ACTIONS[1],newState));
		}
		if (posicionAspirador<AspiratorState.RIGHT){
			newState=new AspiratorState(posicionAspirador+1,leftCleaning,centerCleaning,rightCleaning);
			movements.add(new Successor(ACTIONS[2],newState));			
		}		
		return movements;
	}
	

}
