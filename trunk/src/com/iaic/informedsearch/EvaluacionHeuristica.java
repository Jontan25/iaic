/**
 * 
 */
package com.iaic.informedsearch;

import problema.Nodo;
import problema.Problema;

/**
 * Función de evaluación según la estimación heurística.
 * Esta evaluación se usa en algoritmos informados como
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
