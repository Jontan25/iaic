/**
 * 
 */
package com.iaic.search;

import datastructures.ExpandNode;
import datastructures.OpenedStructure;
import problem.Problem;
import problem.Node;
import java.util.Vector;

/**
 * This class manage the search.
 * @author mario
 */
public abstract class SearchQueue extends ExpandeNodo {

	public SearchQueue(){}
	/**
	 * Esta funci�n recibe un problema y una estructura de abiertos vac�a
	 * y comienza una b�squeda del estado objetivo. Comienza creando un
	 * nodo con el estado inicial y meti�ndolo en abiertos. A partir de
	 * ah�, comienza un bucle en el que extrae nodos de abiertos, los
	 * eval�a y en caso de no ser objetivo, los expande y mete a abiertos.
	 * @param p Problema para el que se realiza la b�squeda. Se necesita
	 * para poder hacer el test de evaluaci�n de objetivos.
	 * @param abiertos la estructura de nodos abiertos. En funci�n de la 
	 * b�squeda concreta, ser� una pila, cola, cola de prioridad...
	 * @return Vector con los operadores aplicados desde el estado inicial
	 * hasta el primer estado objetivo encontrado.
	 */
	public Vector<String> buscar(Problema p,EstructuraAbiertos abiertos) {
		Nodo nodoinicial=new Nodo(p.getEstadoInicial());
		abiertos.agregar(nodoinicial);
		//se a�ade el nodo inicial a abiertos.
		while (!abiertos.esVacia()) {
			Nodo act=abiertos.extraer();
			if (p.esEstadoObjetivo(act.getEstado())) {
				return act.caminoOperadores();
			}
			//se extrae el siguiente nodo de abiertos
			//si es objetivo, se acab�
			expandirYAgregar(p,abiertos,act);
			//y si no es objetivo, se generan los nodos hijos
			//y se agregan a abiertos.
		}
		return new Vector<String>();//esto no deber�a pasar
	}
	
	public abstract void AddandExpand(Problem p, OpenedStructure opened, Node n);
}