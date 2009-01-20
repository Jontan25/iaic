/**
 * 
 */
package com.iaic.informedsearch;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

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
	public Double obtenerValor(Problem p, Node n) {
		return new Double(p.getFunHeuristica().valorHeuristico(n.getEstado()));
	}

}
