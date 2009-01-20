/**
 * 
 */
package com.iaic.informedsearch;

import problema.Nodo;
import problema.Problema;

/**
 * Función de evaluación según la estimación heurística
 * + el coste. Esta es la que se usa en A*, por ejemplo.
 * f(n)=g(n)+h'(n);
 * @author alberto
 *
 */
public class EvaluacionHeuristicayCoste implements FuncionEvaluacion {

	/* (non-Javadoc)
	 * @see busquedas.informadas.FuncionEvaluacion#obtenerValor(problema.Problema, problema.Nodo)
	 */
	public Double obtenerValor(Problema p, Nodo n) {
		return new Double(n.getCosteTotal()+
						  p.getFunHeuristica().valorHeuristico(n.getEstado()));
	}

}
