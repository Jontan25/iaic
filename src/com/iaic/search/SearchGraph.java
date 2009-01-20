/**
 * 
 */
package com.iaic.search;

import problem.Node;
import problem.Problem;
import dataStructure.OpenedStructure;
import java.util.HashSet;
import java.util.Vector;
/**
 * This class is more complex than SearchQueue, because add a closed
 * node structure to make cycle control an optimize a bit more the search.
 * We use a hash table to represent the closed structure.
 * @author mario
 */
public class SearchGraph extends SearchQueue {
	
	HashSet<Object> closed;
	
	public SearchGraph() {
		closed=new HashSet<Object>();
		closed.clear();
	}
	/**  
	 * Determina si el estado de un nodo está en cerrados
	 * Tell us is the state of a node is in the closed structure.
	 * @param n the node.
	 * @return True if the state is in the closed structure.
	 */
	private boolean isinClosed(Node n) {
		return closed.contains(n.getState());
	}
	/* (non-Javadoc)
	 * @see busqueda.ColaBusqueda#expandirYAgregar(problema.Problema, estructurasDeDatos.EstructuraAbiertos, problema.Nodo)
	 */
	public void AddandExpand(Problem p, OpenedStructure opened, Node n) {
		if (!isinClosed(n)) {
			closed.add(n.getState());
			Vector<Node> sons=expandNode(n,p);
			opened.add(sons);
		}

	}
	/* Añade el resetear la estructura de cerrados. Así se
	 * pueden hacer más búsquedas sin destruir la estructura.
	 * (non-Javadoc)
	 * @see busqueda.ColaBusqueda#buscar(problema.Problema, estructurasDeDatos.EstructuraAbiertos)
	 */
	public Vector<String> search(Problem p, OpenedStructure opened) {
		closed.clear();
		return super.search(p, opened);
	}

}
