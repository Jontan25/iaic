package com.iaic.problems.blocks;
import java.util.List;
import java.util.Vector;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;


/**
 * @author Enrique López Mañas
 */

public class BlocksSuccessorFunction implements SuccessorFunction{

	public static String[] ACTIONS={"poner A en P","poner A en Q","poner A en R",
									"poner B en P","poner B en Q","poner B en R",
									"poner C en P","poner C en Q","poner C en R",};
	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	
	public List getSuccessors(Object estado) {
		List movements = new Vector();
		BlocksState blocksState = (BlocksState) estado;
		BlocksState newState;
		
		String posicionA = blocksState.getOverA( );
		String posicionB = blocksState.getOverB( );
		String posicionC = blocksState.getOverC( );
		
		String topP = blocksState.dameCima ( BlocksState.TABLE_NAMES[0] );
		String topQ = blocksState.dameCima ( BlocksState.TABLE_NAMES[1] );
		String topR = blocksState.dameCima ( BlocksState.TABLE_NAMES[2] );
		
		if ( BlocksState.isBlock ( topP ) ){
			if ( topP.equals(BlocksState.BLOCKS_NAMES[0] ) ){
				try {
					newState = new BlocksState( topQ , posicionB , posicionC );
					movements.add ( new Successor ( ACTIONS[1],newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( topR , posicionB , posicionC );
					movements.add ( new Successor ( ACTIONS[2] , newState ) );
				} catch (Exception e) {
				}
        	} else if ( topP.equals ( BlocksState.BLOCKS_NAMES[1] ) ) {
				try {
					newState = new BlocksState ( posicionA , topQ , posicionC );
					movements.add ( new Successor ( ACTIONS[4],newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , topR , posicionC);
					movements.add ( new Successor ( ACTIONS[5],newState ) ) ;
				} catch (Exception e) {
				}			
			} else if ( topP.equals ( BlocksState.BLOCKS_NAMES[2] ) ){
				try {
					newState = new BlocksState ( posicionA , posicionB , topQ );
					movements.add ( new Successor ( ACTIONS[7] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , posicionB , topR ) ;
					movements.add ( new Successor ( ACTIONS[8] , newState ) ) ;
				} catch (Exception e) {
				}
			
			}
		}
		if ( BlocksState.isBlock ( topQ ) ) {
			if ( topQ.equals ( BlocksState.BLOCKS_NAMES[0] ) ) {
				try {
					newState = new BlocksState ( topP , posicionB , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[0] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( topR , posicionB , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[2] , newState ) ) ;
				} catch (Exception e) {
				}
			} else if ( topQ.equals ( BlocksState.BLOCKS_NAMES[1] ) ) {
				try {
					newState = new BlocksState ( posicionA , topP , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[3] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , topR , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[5] , newState ) ) ;
				} catch (Exception e) {
				}
			
			} else if ( topQ.equals ( BlocksState.BLOCKS_NAMES[2] ) ) {
				try {
					newState = new BlocksState ( posicionA , posicionB , topP ) ;
					movements.add ( new Successor ( ACTIONS[6] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , posicionB , topR ) ;
					movements.add ( new Successor ( ACTIONS[8] , newState ) ) ;
				} catch (Exception e) {
				}
			}	
		}
		if (BlocksState.isBlock(topR)){
			if (topR.equals(BlocksState.BLOCKS_NAMES[0])){
				try {
					newState=new BlocksState(topP,posicionB,posicionC);
					movements . add ( new Successor ( ACTIONS[0] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( topQ , posicionB , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[1] , newState ) ) ;
				} catch (Exception e) {
				}
			} else if  ( topR.equals ( BlocksState.BLOCKS_NAMES[1] ) ) {
				try {
					newState = new BlocksState ( posicionA , topP , posicionC );
					movements.add ( new Successor ( ACTIONS[3] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , topQ , posicionC ) ;
					movements.add ( new Successor ( ACTIONS[4] , newState ) );
				} catch (Exception e) {
				}
			
			} else if ( topR.equals ( BlocksState.BLOCKS_NAMES[2] ) ) {
				try {
					newState = new BlocksState ( posicionA , posicionB , topP ) ;
					movements.add ( new Successor ( ACTIONS[6] , newState ) ) ;
				} catch (Exception e) {
				}
				try {
					newState = new BlocksState ( posicionA , posicionB , topQ ) ;
					movements.add ( new Successor ( ACTIONS[7] , newState ) ) ;
				} catch (Exception e) {
				}
			
			}
		}		
		return movements;
	}
	

}
