/**
 * 
 */
package com.iaic.informedsearch;

import problema.Nodo;
import problema.Problema;

/**
 * Funci�n de evaluaci�n seg�n la estimaci�n heur�stica.
 * Esta evaluaci�n se usa en algoritmos informados como
 * el voraz, por ejemplo.f(n)=h(n);
 * @author alberto
 *
 */
public class EvaluacionHeuristica implements FuncionEvaluacion {

	/* (non-Javadoc)
	 * @see busquedas.informadas.FuncionEvaluacion#obtenerValor(problema.Problema, problema.Nodo)
	 */
	public Double obtenerValor(Problema p, Nodo n) {
		return new Double(p.getFunHeuristica().valorHeuristico(n.getEstado()));
	}

}
