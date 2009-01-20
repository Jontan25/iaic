/**
 * 
 */
package com.iaic.problems.OchoPuzzle;

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
	public ochoPuzzleProblema(ochoPuzzleEstado e) {
		super(e,new ochoPuzzleSucesor(),new ochoPuzzleObjetivo(),new FuncionCosteStandard(),new ochoPuzzleHeuristicaManhattan());
	}
}
