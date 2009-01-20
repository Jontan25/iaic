/**
 * 
 */
package com.iaic.informedsearch;
import com.iaic.problem.Node;
import com.iaic.problem.Problem;

/**
 * Interfaz para la funci�n de evaluaci�n del nodo mejor
 * en los algoritmos de b�squeda informados, como A* o
 * el voraz. 
 * @author alberto
 *
 */
public interface FuncionEvaluacion {

	public Double obtenerValor(Problem p,Node n);
}
