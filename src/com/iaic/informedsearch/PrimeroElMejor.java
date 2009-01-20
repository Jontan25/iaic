/**
 * 
 */
package com.iaic.informedsearch;

import java.util.Comparator;

import problema.Nodo;
import problema.Problema;
import busqueda.BusquedaPrioridad;
import busqueda.ColaBusqueda;

/**
 * Esta clase representa lo com�n que tienen todas las 
 * b�squedas informadas que usan el criterio de evaluar
 * qu� nodo es el m�s prometedor para que sea el siguiente
 * a expandir. Para ello, se guarda una referencia a una
 * funci�n de evaluaci�n que se le pasar� por la
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
	protected Comparator<Nodo> getComparator(final Problema p) {
		return new Comparator<Nodo>() {
			public int compare(Nodo uno, Nodo dos) {
				Double f1 = funEvaluacion.obtenerValor(p,uno);
				Double f2 = funEvaluacion.obtenerValor(p,dos);

				return f1.compareTo(f2);
			}
		};
	}

}
