/**
 * El problema de 3-puzzle no siempre tiene solución. Muevas como
 * muevas el hueco, solo se permite rotar las piezas, bien en sentido
 * de las agujas del reloj o en sentido contrario, por lo que,
 * si las piezas están cruzadas es imposible colocarlas en orden
 * correcto. Esto lo diferencia del 8-puzzle.
 */
package com.iaic.problems.threePuzzle;

import problema.interfacesFunciones.FuncionObjetivo;

/**
 * Clase que implementará la función objetivo. En este caso,
 * para los estados del tres Puzzle.
 * @author alberto
 *
 */
public class tresPuzzleObjetivo implements FuncionObjetivo {

	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		tresPuzzleEstado c=(tresPuzzleEstado)candidato;
		//construimos un estado objetivo auxiliar
		//(la constructora por defecto lo hace)
		tresPuzzleEstado objetivo=new tresPuzzleEstado();
		objetivo.hacerObjetivo();
		return c.equals(objetivo);//y miramos si es igual.
	}
}
