/**
 * 
 */
package com.iaic.informedsearch;
import problema.Problema;
import problema.Nodo;

/**
 * Interfaz para la funci�n de evaluaci�n del nodo mejor
 * en los algoritmos de b�squeda informados, como A* o
 * el voraz. 
 * @author alberto
 *
 */
public interface FuncionEvaluacion {

	public Double obtenerValor(Problema p,Nodo n);
}
