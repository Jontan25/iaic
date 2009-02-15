package com.iaic.problems.bottles;

import java.util.List;
import java.util.Vector;

import aima.search.framework.StepCostFunction;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/**
 * @author Enrique López Mañas
 */

public class BottlesSuccessorFunction implements SuccessorFunction{
	public static String[] ACTIONS={"llena3 ("+BottlesStepCostFunction.COST_FULFILL_3+")",
									"llena4 ("+BottlesStepCostFunction.COST_FULFILL_4+")",
									"vacia3 ("+BottlesStepCostFunction.COST_EMPTY_3+")",
									"vacia4 ("+BottlesStepCostFunction.COST_EMPTY_4+")",
									"vierte3 ("+BottlesStepCostFunction.COST_POUR_3+")",
									"vierte4 ("+BottlesStepCostFunction.COST_POUR_4+")"
									};

	public List getSuccessors( Object state ) {
		List movements = new Vector( );
		BottlesState bottlesState= ( BottlesState ) state;
		BottlesState newState;
		int bottle1 = bottlesState.getBottle1( );
		int bottle2=bottlesState.getBottle2( );
		if( bottle1 < 4 ){
			try {
				newState = new BottlesState ( 4 , bottle2 ) ;
				movements.add ( new Successor ( ACTIONS[1] , newState ) );
			} catch (Exception e) {
			}
		}
		if ( bottle2 < 3 ) {
			try {
				newState = new BottlesState ( bottle1 , 3 );
				movements.add( new Successor ( ACTIONS[0] , newState ) );
			} catch (Exception e) {
			}
		}
		if ( bottle1 > 0 && bottle2 < 3 ) {
			try {
				int c2 =3-bottle2;
				int b1;
				int b2;
				if ( bottle1 >= c2 ){
					b2 = 3;
					b1 = bottle1 - c2;
				}
				else {
					b2 = bottle1 + bottle2;
					b1 = 0;
				}
				newState = new BottlesState ( b1 , b2 );
				movements.add ( new Successor( ACTIONS[5] , newState ) ) ;
			} catch (Exception e) {
			}
		}
		if ( bottle1 < 4 && bottle2 > 0 ) {
			try {
				int c1 = 4-bottle1;
				int b1;
				int b2;
				if ( bottle2 >= c1 ){
					b1 = 4;
					b2 = bottle2-c1;
				}
				else {
					b1 = bottle1+bottle2;
					b2 = 0;
				}
				newState = new BottlesState( b1 , b2 );
				movements.add(new Successor ( ACTIONS[4] , newState ) ) ;
			} catch (Exception e) {
			}
		}
		
		if ( bottle1 > 0 ){
			try {
				newState = new BottlesState ( 0 , bottle2 ) ;
				movements.add ( new Successor ( ACTIONS[3] , newState ) ) ;
			} catch (Exception e) {
			}
		}
		if ( bottle2 > 0 ) {
			try {
				newState = new BottlesState ( bottle1 , 0 );
				movements.add ( new Successor ( ACTIONS[2] , newState ) ) ;
			} catch (Exception e) {
			}
		}
		
		return movements;
	}
	
}
