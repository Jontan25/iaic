/**
 * 
 */
package com.iaic.informedsearch;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

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
	public Double obtenerValor(Problem p, Node n) {
		return new Double(n.getCosteTotal()+
						  p.getFunHeuristica().valorHeuristico(n.getEstado()));
	}

}
