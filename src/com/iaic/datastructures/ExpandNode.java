/**
 * 
 */
package com.iaic.datastructures;
import java.util.Vector;
import problema.Nodo;
import problema.Problema;
import problema.Sucesor;
/**
 * Por el momento, esta clase solo sirve para tener la función
 * expandirNodo. Esta función la necesitan todas las búsquedas,
 * así que saco factor común y luego, que la hereden.
 * @author alberto
 *
 */
public class ExpandNode {
	
	public ExpandNode() {}
	
	/**
	 * Dado un problema con sus funciones, y un nodo de espacio
	 * de búsqueda del mismo problema, que se supone recién sacado
	 * de la estructura de abiertos, esta función lo expande,
	 * creando todos sus nodos hijos, y devolviéndolos en una 
	 * lista.
	 * @param n El nodo que se va a expandir.
	 * @param p El problema al que pertenece el nodo. Se necesita
	 * porque en él se encuentra la función sucesor que creará
	 * los estados sucesores necesarios para crear los nodos hijos.
	 * @return Una lista de todos los nodos hijos resultado de
	 * expandir n.
	 */
	public Vector<Nodo> expandirNodo(Nodo n, Problema p) {
		Vector<Nodo> hijos=new Vector<Nodo>();
		hijos.clear();//preparamos la estructura de nodos hijos
		
		Vector<Sucesor> sucesores=p.getFunSucesor().getSucesores(n.getEstado());
		/*con esto tenemos un vector de estados sucesores de nodo n.
		 en cada uno, tenemos también el operador aplicado a n para llegar
		 Ahora, de cada uno tenemos que crear un nodo y añadirlo a la lista.
		 */
		int numSucesores=sucesores.size();
		//se toman antes, porque dentro del bucle se quitan
		//nodos y el bucle no da las vueltas que debe
		for (int i=0;i<numSucesores;i++) {
			Sucesor s=sucesores.remove(0);
			double gn=p.getFunCoste().calcularCoste(n.getEstado(), s.getEstado(), s.getOperador());
			Nodo nuevoNodo=new Nodo(s.getEstado(),n,s.getOperador(),gn,n.getCosteTotal()+gn,n.getProfundidad()+1);
			hijos.add(nuevoNodo);
		}
		return hijos;
	}
}
