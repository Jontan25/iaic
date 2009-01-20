/**
 * 
 */
package com.iaic.search;

import problema.Nodo;
import problema.Problema;
import estructurasDeDatos.EstructuraAbiertos;
import java.util.HashSet;
import java.util.Vector;
/**
 * Clase más compleja que ColaBusqueda, que añade una estructura
 * de nodos cerrados para incorporar control de ciclos y optimizar
 * un poco más las búsquedas por el espacio de estados.
 * Para la representación de la estructura de cerrados se elige
 * una tabla hash como en AIMA.
 * @author alberto
 *
 */
public class GrafoBusqueda extends SearchQueue {
	
	HashSet<Object> cerrados;
	
	public GrafoBusqueda() {
		cerrados=new HashSet<Object>();
		cerrados.clear();
	}
	/**
	 * Determina si el estado de un nodo está en cerrados
	 * @param n El nodo.
	 * @return True si el estado del nodo n ya está en cerrados.
	 */
	private boolean estaenCerrados(Nodo n) {
		return cerrados.contains(n.getEstado());
	}
	/* (non-Javadoc)
	 * @see busqueda.ColaBusqueda#expandirYAgregar(problema.Problema, estructurasDeDatos.EstructuraAbiertos, problema.Nodo)
	 */
	@Override
	public void expandirYAgregar(Problema p, EstructuraAbiertos abiertos, Nodo n) {
		if (!estaenCerrados(n)) {
			cerrados.add(n.getEstado());
			Vector<Nodo> hijos=expandirNodo(n,p);
			abiertos.agregar(hijos);
		}

	}
	/* Añade el resetear la estructura de cerrados. Así se
	 * pueden hacer más búsquedas sin destruir la estructura.
	 * (non-Javadoc)
	 * @see busqueda.ColaBusqueda#buscar(problema.Problema, estructurasDeDatos.EstructuraAbiertos)
	 */
	public Vector<String> buscar(Problema p,EstructuraAbiertos abiertos) {
		cerrados.clear();
		return super.buscar(p, abiertos);
	}

}
