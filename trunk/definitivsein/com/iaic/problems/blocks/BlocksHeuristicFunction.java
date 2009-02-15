package com.iaic.problems.blocks;

import aima.search.framework.HeuristicFunction;

/**
 * @author Enrique López Mañas
 */

public class BlocksHeuristicFunction implements HeuristicFunction {

	
	private BlocksState _finalState ;
	public BlocksHeuristicFunction(BlocksState finalState) {
		super( );
		this._finalState=finalState;
	}

	public double getHeuristicValue(Object state) {
		BlocksState blocksState=(BlocksState) state;
		String actualTableA = blocksState.dameMesa(BlocksState.BLOCKS_NAMES[0]);
		String actualTableB = blocksState.dameMesa(BlocksState.BLOCKS_NAMES[1]);
		String actualTableC = blocksState.dameMesa(BlocksState.BLOCKS_NAMES[2]);
		
		int actualHeightA = blocksState.dameAlturaA();
		int actualHeightB = blocksState.dameAlturaB();
		int actualHeightC = blocksState.dameAlturaC();
		
		String finalTableA = _finalState.dameMesa(BlocksState.BLOCKS_NAMES[0]);
		String finalTableB = _finalState.dameMesa(BlocksState.BLOCKS_NAMES[1]);
		String finalTableC = _finalState.dameMesa(BlocksState.BLOCKS_NAMES[2]);
		
		int finalHeightA = _finalState.dameAlturaA();
		int finalHeightB = _finalState.dameAlturaB();
		int finalHeightC = _finalState.dameAlturaC();
		
		int value=0;
		if (actualTableA.equals(finalTableA)){
			//If a block is in the same table as its solution...
			if (actualHeightA!=finalHeightA){
				//but is not in the corresponding height, we have to move it at least twice
				value=value+2;
			}
		} else {
			//If is not over the table we must move if at least once
			value++;
		}
		//And the same for the other blocks
		
		if ( actualTableB.equals( finalTableB )){
			if ( actualHeightB != finalHeightB ){
				value += 2;
			}
		} else {
			value++;
		}
		
		if ( actualTableC.equals( finalTableC )){
			if ( actualHeightC != finalHeightC ){
				value += 2;
			}
		} else {
			value++;
		}		
		return value;
	}

	
}
