/**
 * 
 */
package com.iaic.search;

import estructurasDeDatos.ExpandeNodo;
import estructurasDeDatos.EstructuraAbiertos;
import problema.Problema;
import problema.Nodo;
import java.util.Vector;

/**
 * 
 * Esta clase es la encargada de comenzar y gestionar la búsqueda.
 * @author alberto
 *
 */
public abstract class SearchQueue extends ExpandeNodo {

	public SearchQueue(){}
	/**
	 * Esta función recibe un problema y una estructura de abiertos vacía
	 * y comienza una búsqueda del estado objetivo. Comienza creando un
	 * nodo con el estado inicial y metiéndolo en abiertos. A partir de
	 * ahí, comienza un bucle en el que extrae nodos de abiertos, los
	 * evalúa y en caso de no ser objetivo, los expande y mete a abiertos.
	 * @param p Problema para el que se realiza la búsqueda. Se necesita
	 * para poder hacer el test de evaluación de objetivos.
	 * @param abiertos la estructura de nodos abiertos. En función de la 
	 * búsqueda concreta, será una pila, cola, cola de prioridad...
	 * @return Vector con los operadores aplicados desde el estado inicial
	 * hasta el primer estado objetivo encontrado.
	 */
	public Vector<String> buscar(Problema p,EstructuraAbiertos abiertos) {
		Nodo nodoinicial=new Nodo(p.getEstadoInicial());
		abiertos.agregar(nodoinicial);
		//se añade el nodo inicial a abiertos.
		while (!abiertos.esVacia()) {
			Nodo act=abiertos.extraer();
			if (p.esEstadoObjetivo(act.getEstado())) {
				return act.caminoOperadores();
			}
			//se extrae el siguiente nodo de abiertos
			//si es objetivo, se acabó
			expandirYAgregar(p,abiertos,act);
			//y si no es objetivo, se generan los nodos hijos
			//y se agregan a abiertos.
		}
		return new Vector<String>();//esto no debería pasar
	}
	
	public abstract void expandirYAgregar(Problema p, EstructuraAbiertos abiertos, Nodo n);
}
