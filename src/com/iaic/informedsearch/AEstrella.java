package com.iaic.informedsearch;
import busqueda.ColaBusqueda;

/**
 * Algoritmo A*. Para la evaluación del siguiente nodo
 * usa f(n)=g(n)+h'(n).
 * @author alberto
 *
 */
public class AEstrella extends PrimeroElMejor {

	public AEstrella(ColaBusqueda c) {
		super(c,new EvaluacionHeuristicayCoste());
	}
}
