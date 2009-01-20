/**
 * 
 */
package com.iaic.datastructures;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Esta clase representa un grafo de elementos del tipo E.
 * Se va a usar para representar el grafo de planetas en el problema de
 * los planetas.
 * @author alberto
 *
 */
public class Grafo<E> {
	/**
	 * Número máximo de nodos que tendrá el grafo.
	 */
	private final int MAX_NODOS=256;
	
	/**
	 * Un ArrayList de listas enlazadas. Cada una de esas listas enlazadas
	 * representa los nodos adyacentes. Por ejemplo, listas[1] es una
	 * lista enlazada con los nodos adyacentes al nodo 1.
	 * Dentro del Nodo (NodoGrafo) está el elemento, del tipo E, y la
	 * distancia de este elemento al nodo 1.
	 */
	private ArrayList<LinkedList<NodoAdyacencia<E>>> listas;
	/**
	 * Una lista de los elementos que tenemos. Me parece que se necesita.
	 */
	private ArrayList<E> elementos;
	/**
	 * Número de elementos del grafo.
	 */
	private int numElementos;
	/**
	 * Número máximo de elementos. Serán los que se pasen en la constructora.
	 */
	private int maxElementos;
	
	public Grafo() {
		listas=null;numElementos=0;elementos=null;maxElementos=MAX_NODOS;
	}
	/**
	 * Esta constructora inicializa el arraylist para i elementos. Pero
	 * ojo, solo inicia el arraylist, vacío. Esto significa que no contiene
	 * ninguna lista enlazada, por lo que 
	 * @param i
	 */
	public Grafo(int i) {
		listas= new ArrayList<LinkedList<NodoAdyacencia<E>>>(i);
		elementos=new ArrayList<E>(i);
		numElementos=0;maxElementos=numElementos;
	}
	/**
	 * Este método agrega un nuevo elemento al grafo. Primero comprueba
	 * si éste tiene capacidad para un elemento más y si no está ya en el
	 * grafo. Después lo agrega a la lista de elementos, y crea una nueva
	 * linkedlist vacía, para cuando se quiera agregar adyacentes a él.
	 * @param elem El elemento que se quiere agregar al grafo.
	 * @return True si se ha podido agregar con normalidad, False si 
	 * no había espacio o ya existía en el grafo (el grafo no permite
	 * elementos repetidos).
	 */
	public boolean agregarElemento(E elem) {
		if ((numElementos==maxElementos) || (elementos.contains(elem))) 
			return false;
		elementos.add(elem);
		listas.add(new LinkedList<NodoAdyacencia<E>>());
		numElementos++;
		return true;		
	}
	/**
	 * Se agrega una arista que une los vértices v1 y v2. Como es un grafo
	 * no dirigido, hay que añadir las aristas v1,v2 y v2,v1.
	 * Primero se comprueba si los dos vértices existen, ya que si no, se
	 * debe dar error.
	 * @param v1 Uno de los vértices de la arista.
	 * @param v2 El otro vértice de la arista.
	 * @param d La distancia, que es la longitud de la arista.
	 * @return True si se puede agregar bien la arista, false en caso contrario.
	 */
	public boolean agregarVertice(E v1, E v2, int d) {
		if (!elementos.contains(v1) || !elementos.contains(v2))
			return false;
		//añadimos la arista v1,v2
		NodoAdyacencia<E> primero=new NodoAdyacencia<E>(v2,d);
		int indice=elementos.indexOf(v1);
		listas.get(indice).add(primero);
		//ahora añadimos la arista v2,v1
		NodoAdyacencia<E> segundo=new NodoAdyacencia<E>(v1,d);
		indice=elementos.indexOf(v2);
		listas.get(indice).add(segundo);
		return true;
	}
	/**
	 * Devuelve la lista de elementos adyacentes a v
	 * @param v El vértice del que se piden los adyacentes.
	 * @return La lista.
	 */
	public LinkedList<NodoAdyacencia<E>> adyacentes(E v) {
		int index=elementos.indexOf(v);
		if (index==-1) return null;
		if (listas.get(index).isEmpty()) return null;
		return listas.get(index);
	}
	
}
