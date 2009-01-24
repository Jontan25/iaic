/**
 * El problema de 3-puzzle no siempre tiene solución. Muevas como
 * muevas el hueco, solo se permite rotar las piezas, bien en sentido
 * de las agujas del reloj o en sentido contrario, por lo que,
 * si las piezas están cruzadas es imposible colocarlas en orden
 * correcto. Esto lo diferencia del 8-puzzle.
 */
package com.iaic.problems.threePuzzle;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * @author alberto
 *
 */
public class tresPuzzleProblema extends Problema {
	/**
	 * 
	 * @param e El estado inicial del problema.
	 */
	public tresPuzzleProblema(tresPuzzleEstado e) {
		super(e,new tresPuzzleSucesor(),new tresPuzzleObjetivo(),new FuncionCosteStandard(),new tresPuzzleHeuristicaManhattan());
	}
}
