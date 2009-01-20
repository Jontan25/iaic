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
 * La b�squeda de coste uniforme es una b�squeda basada en prioridad.
 * Se tiene en cuenta el coste del camino al nodo en lugar de la
 * profundidad o la anchura, por lo que se van tomando los nodos cuyo
 * coste del camino es menor, para desplegarlos.
 * Esta b�squeda es completa si no existen caminos infinitos de coste
 * finito y �ptima si todos los operadores tienen coste >=0.
 * La complejidad en tiempo y espacio equivale a la b�squeda de 
 * primero en anchura.
 * CUIDADO CON EL CONTROL DE CICLOS, puede hacer que esta b�squeda deje
 * de ser �ptima.
 * (Dijkstra, 1959)
 * @author alberto
 *
 */
public class UniformCost extends BusquedaPrioridad {
	
	public UniformCost(ColaBusqueda c) {
		colaBusqueda=c;
	}
	/* Esto se necesita porque al crear la cola de prioridad, hay que 
	 * decirle a java c�mo evaluar la prioridad, y para eso se le mete
	 * una clase comparator, en cuya operaci�n "compare" se eval�e,
	 * dados dos nodos, cu�l es m�s prioritario. En este caso se escoge
	 * el criterio del camino m�nimo.
	 * (non-Javadoc)
	 * @see busqueda.BusquedaPrioridad#getComparator(problema.Problema)
	 */
	public Comparator<Node> getComparator(Problem p) {
		return new ComparatorGn();
	}
}
