/**
 * 
 */
package com.iaic.datastructures;

/**
 * Esta clase es para las listas enlazadas que representarán los nodos
 * adyacentes de la clase Grafo. No es más que una pareja elem,distancia.
 * @author alberto
 *
 */
public class NodoAdyacencia<T> {
	/**
	 * El elemento del grafo.
	 */
	private T elemento;
	/**
	 * La distancia a la que está.
	 */
	private int distancia;
	/**
	 * Constructora por defecto, deja el nodo nulo.
	 */
	public NodoAdyacencia() {
		elemento=null;distancia=0;
	}
	/**
	 * Inicia el nodo con un elemento, y la distancia a 0.
	 * @param elem El elemento correspondiente.
	 */
	public NodoAdyacencia(T elem) {
		elemento=elem;distancia=0;
	}
	/**
	 * Inicia el nodo con un elemento y una distancia predeterminadas.
	 * @param elem Elemento con el que se iniciará el nodo.
	 * @param d Distancia del elemento.
	 */
	public NodoAdyacencia(T elem, int d) {
		elemento=elem;distancia=d;
	}
	/**
	 * Devuelve una referencia al elemento que contiene.
	 * @return Elemento de nodo.
	 */
	public T getElemento() {
		return elemento;
	}
	/**
	 * Pone un nuevo elemento en el nodo.
	 * @param e Nuevo elemento.
	 */
	public void setElemento(T e) {
		elemento=e;
	}
	/**
	 * Devuelve la distancia del elemento, contenida en el nodo.
	 * @return Distancia del elemento.
	 */
	public int getDistancia() {
		return distancia;
	}
	/**
	 * Cambia la distancia almacenada en el nodo.
	 * @param d La nueva distancia.
	 */
	public void setDistancia(int d) {
		distancia=d;
	}
}
