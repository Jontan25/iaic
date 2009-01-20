/**
 * 
 */
package com.iaic.datastructures;

import java.util.Vector;
import java.util.Comparator;
import java.util.PriorityQueue;
import problema.Nodo;

/**
 * It's a priority queue for the expanded nodes but not visited yet.
 * @authors jose, mario
 *
 */
public class OpenedPriorityQueue implements OpenedStructure {

	private PriorityQueue<Nodo> cola;
	
	
	public OpenedPriorityQueue(Comparator<Nodo> c) {
		cola=new PriorityQueue<Nodo>(20,c);
		cola.clear();
	}
	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(problema.Nodo)
	 */
	public boolean agregar(Nodo n) {
		return cola.add(n);
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(java.util.Vector)
	 */
	public boolean agregar(Vector<Nodo> v) {
		return cola.addAll(v);
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#esVacia()
	 */
	public boolean esVacia() {
		return cola.isEmpty();
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#extraer()
	 */
	public Nodo extraer() {
		return cola.poll();
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#numNodos()
	 */
	public int numNodos() {
		return cola.size();
	}

}