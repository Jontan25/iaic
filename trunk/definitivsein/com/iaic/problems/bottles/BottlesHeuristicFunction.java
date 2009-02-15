package com.iaic.problems.bottles;
import com.iaic.problems.bottles.BottlesState;

import aima.search.framework.HeuristicFunction;

/**
 * @author Enrique López Mañas
 */

public class BottlesHeuristicFunction implements HeuristicFunction {
	BottlesState _finalState;

	public BottlesHeuristicFunction( BottlesState _finalState ) {
		this._finalState = _finalState;
	}

	public double getHeuristicValue ( Object state ) {
		BottlesState bottlesState = (BottlesState) state;
		int value = -1 ;
		int numLitres = bottlesState.getBottle1( ) + bottlesState.getBottle2( ) ;
		int numFinalLitres = _finalState.getBottle1( ) + _finalState.getBottle2( );
		int diference = numFinalLitres - numLitres;
		if ( diference > 0 ){
			if ( BottlesStepCostFunction.COST_EMPTY_3 < BottlesStepCostFunction.COST_EMPTY_4 ){
				value = BottlesStepCostFunction.COST_EMPTY_3;
			}else {
				value = BottlesStepCostFunction.COST_EMPTY_4;
			}
		} else if ( diference < 0 ) {
			if (BottlesStepCostFunction.COST_FULFILL_3 < BottlesStepCostFunction.COST_FULFILL_4 ) {
				value = BottlesStepCostFunction.COST_FULFILL_3;
			} else {
				value = BottlesStepCostFunction.COST_FULFILL_4;
			}
		} else {
			if ( BottlesStepCostFunction.COST_POUR_3 < BottlesStepCostFunction.COST_POUR_4 ) {
				value = BottlesStepCostFunction.COST_POUR_3;
			} else {
				value = BottlesStepCostFunction.COST_POUR_4;
			}
		}
		
		return value;
	}

	
}
