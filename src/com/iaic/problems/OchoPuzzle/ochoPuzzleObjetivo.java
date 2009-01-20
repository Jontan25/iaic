/**
 * 
 */
package com.iaic.problems.OchoPuzzle;

import problema.interfacesFunciones.FuncionObjetivo;

/**
 * Clase que implementará la función objetivo. En este caso,
 * para los estados del ocho Puzzle.
 * @author alberto
 *
 */
public class ochoPuzzleObjetivo implements FuncionObjetivo {

	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		ochoPuzzleEstado c=(ochoPuzzleEstado)candidato;
		//construimos un estado objetivo auxiliar
		//(la constructora por defecto lo hace)
		ochoPuzzleEstado objetivo=new ochoPuzzleEstado();
		objetivo.hacerObjetivo();
		return c.equals(objetivo);//y miramos si es igual.
	}
}
