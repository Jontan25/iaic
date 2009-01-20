package com.iaic.informedsearch;
import busqueda.ColaBusqueda;

/**
 * B�squeda voraz. Usa la mejor estimaci�n heur�stica
 * para saber cual es el nodo siguiente.
 * @author alberto
 *
 */
public class Voraz extends PrimeroElMejor {

	public Voraz(ColaBusqueda c) {
		super(c,new EvaluacionHeuristica());
	}
}
