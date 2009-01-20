/**
 * 
 */
package com.iaic.informedsearch;
import problema.Problema;
import problema.Nodo;

/**
 * Interfaz para la función de evaluación del nodo mejor
 * en los algoritmos de búsqueda informados, como A* o
 * el voraz. 
 * @author alberto
 *
 */
public interface FuncionEvaluacion {

	public Double obtenerValor(Problema p,Nodo n);
}
