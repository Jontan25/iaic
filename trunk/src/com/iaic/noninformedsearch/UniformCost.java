/**
 * 
 */
package com.iaic.noninformedsearch;
import problem.Problema;
import problema.Nodo;
import com.iaic.search.PrioritySearch;
import com.iaic.search.SearchQueue;
import java.util.Comparator;

/**
 * La búsqueda de coste uniforme es una búsqueda basada en prioridad.
 * Se tiene en cuenta el coste del camino al nodo en lugar de la
 * profundidad o la anchura, por lo que se van tomando los nodos cuyo
 * coste del camino es menor, para desplegarlos.
 * Esta búsqueda es completa si no existen caminos infinitos de coste
 * finito y óptima si todos los operadores tienen coste >=0.
 * La complejidad en tiempo y espacio equivale a la búsqueda de 
 * primero en anchura.
 * CUIDADO CON EL CONTROL DE CICLOS, puede hacer que esta búsqueda deje
 * de ser óptima.
 * (Dijkstra, 1959)
 * @author alberto
 *
 */
public class UniformCost extends BusquedaPrioridad {
	
	public UniformCost(ColaBusqueda c) {
		colaBusqueda=c;
	}
	/* Esto se necesita porque al crear la cola de prioridad, hay que 
	 * decirle a java cómo evaluar la prioridad, y para eso se le mete
	 * una clase comparator, en cuya operación "compare" se evalúe,
	 * dados dos nodos, cuál es más prioritario. En este caso se escoge
	 * el criterio del camino mínimo.
	 * (non-Javadoc)
	 * @see busqueda.BusquedaPrioridad#getComparator(problema.Problema)
	 */
	public Comparator<Node> getComparator(Problem p) {
		return new ComparatorGn();
	}
}
