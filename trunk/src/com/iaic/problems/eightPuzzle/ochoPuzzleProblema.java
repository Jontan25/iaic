/**
 * 
 */
package com.iaic.problems.eightPuzzle;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * @author alberto
 *
 */
public class ochoPuzzleProblema extends Problema {
	/**
	 * 
	 * @param e El estado inicial del problema.
	 */
	public ochoPuzzleProblema(EightPuzzleState e) {
		super(e,new ochoPuzzleSucesor(),new ochoPuzzleObjetivo(),new FuncionCosteStandard(),new ochoPuzzleHeuristicaManhattan());
	}
}
