package com.iaic.informedsearch;
import busqueda.ColaBusqueda;

/**
 * Búsqueda voraz. Usa la mejor estimación heurística
 * para saber cual es el nodo siguiente.
 * @author alberto
 *
 */
public class Voraz extends PrimeroElMejor {

	public Voraz(ColaBusqueda c) {
		super(c,new EvaluacionHeuristica());
	}
}
