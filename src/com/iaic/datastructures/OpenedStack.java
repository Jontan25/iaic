/**
 * 
 */
package com.iaic.datastructures;

import java.util.Vector;

import problema.Nodo;

/**
 * @author alberto
 *
 */
public class OpenedStack implements OpenedStructure {

	Vector<Nodo> pila;
	
	public OpenedStack() {
		pila=new Vector<Nodo>();
		pila.clear();
	}
	
	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(problema.Nodo)
	 */
	public boolean agregar(Nodo n) {
		pila.insertElementAt(n, 0);
		return true;
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#agregar(java.util.Vector)
	 */
	public boolean agregar(Vector<Nodo> v) {
		Vector<Nodo> a=new Vector<Nodo>();
		a.clear();
		a.addAll(v);
		a.addAll(pila);
		pila=a;
		return true;
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#esVacia()
	 */
	public boolean esVacia() {
		return pila.isEmpty();
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#extraer()
	 */
	public Nodo extraer() {
		return pila.remove(0);
	}

	/* (non-Javadoc)
	 * @see estructurasDeDatos.EstructuraAbiertos#numNodos()
	 */
	public int numNodos() {
		return pila.size();
	}

}
