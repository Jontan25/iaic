/**
 * 
 */
package com.iaic.datastructures;

import java.util.Vector;

import problema.Nodo;

/**
 * Cola de Nodos abiertos.
 * @author alberto
 *
 */
public class ColaAbiertos implements EstructuraAbiertos {

	Vector<Nodo> cola;
	
	public ColaAbiertos() {
		cola=new Vector<Nodo>();
		cola.clear();
	}
	
	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(problema.Nodo)
	 */
	public boolean agregar(Nodo n) {
		cola.add(n);
		return true;
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(java.util.Vector)
	 */
	public boolean agregar(Vector<Nodo> v) {
		cola.addAll(v);
		return true;
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
		return cola.remove(0);
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#numNodos()
	 */
	public int numNodos() {
		return cola.size();
	}

}
