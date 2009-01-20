/**
 * 
 */
package com.iaic.search;

import java.util.Vector;
import java.util.Comparator;
import estructurasDeDatos.ColaPrioridadAbiertos;
import problema.Problema;
import problema.Nodo;

/**
 * Class for search that use a priority queue.
 * @author jose,mario
 *
 */
public abstract class PrioritySearch implements Common {
	/**
	 * This is the search queue structure that is going to be used.
	 * It can be a GraphSearch, if we want to have cycle control.
	 * All the search will use it, so we put it protected.
	 */
	protected SearchQueue searchqueue;
	
	
	/* (non-Javadoc)
	 * @see search.Search#search(problem.Problem)
	 */
	public Vector<String> search(Problem p) {
		return searchqueue.search(p,new ColaPrioridadAbiertos(getComparator(p)));
	}
	/**
	 * Este m�todo se usa para construir la cola de prioridad. Esta
	 * necesita el criterio para evaluar la prioridad entre dos nodos,
	 * y esto se indica mediante una clase Comparator, que implemente
	 * la funci�n "compare", que compara dos nodos y dice cual es m�s
	 * prioritario. Podemos construir diversas clases comparator, cada 
	 * una con una funci�n "compare" que siga los criterios que queramos.
	 * @param p El problema para el cual queremos hacer la b�squeda.
	 * Normalmente, los criterios para comparar se basan en funciones
	 * heur�sticas, de coste, o ambas, y para acceder a estas necesitamos
	 * una referencia al problema.
	 * @return La clase Comparator necesaria para la construcci�n de la
	 * cola de prioridad (java.util.PriorityQueue)
	 * 
	 * This method is used to build a priority queue.The queue needs a criteria
	 * to evaluate the priority between two nodes, and is show as Comparator class
	 * that implements the function "Compare", that compare two nodes and tell us
	 * what has more priority. We can build many other Compartor classes
	 */
	protected abstract Comparator<Nodo> getComparator(Problema p);

}
