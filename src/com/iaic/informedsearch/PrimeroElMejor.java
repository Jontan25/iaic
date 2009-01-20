/**
 * 
 */
package com.iaic.informedsearch;

import java.util.Comparator;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

import busqueda.BusquedaPrioridad;
import busqueda.ColaBusqueda;

/**
 * Esta clase representa lo común que tienen todas las 
 * búsquedas informadas que usan el criterio de evaluar
 * qué nodo es el más prometedor para que sea el siguiente
 * a expandir. Para ello, se guarda una referencia a una
 * función de evaluación que se le pasará por la
 * constructora.
 * @author alberto
 *
 */
public class PrimeroElMejor extends BusquedaPrioridad {

	private FuncionEvaluacion funEvaluacion;
	
	public PrimeroElMejor() {
		funEvaluacion=null;
	}
	
	public PrimeroElMejor(ColaBusqueda c,FuncionEvaluacion e) {
		colaBusqueda=c;funEvaluacion=e;
	}
	
	/* (non-Javadoc)
	 * @see busqueda.BusquedaPrioridad#getComparator(problema.Problema)
	 */
	@Override
	protected Comparator<Node> getComparator(final Problem p) {
		return new Comparator<Node>() {
			public int compare(Node uno, Node dos) {
				Double f1 = funEvaluacion.obtenerValor(p,uno);
				Double f2 = funEvaluacion.obtenerValor(p,dos);

				return f1.compareTo(f2);
			}
		};
	}

}
