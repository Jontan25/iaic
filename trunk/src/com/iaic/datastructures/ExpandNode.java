/**
 * 
 */
package com.iaic.datastructures;
import java.util.Vector;
import problema.Nodo;
import problema.Problema;
import problema.Sucesor;
/**
 * Por el momento, esta clase solo sirve para tener la funci�n
 * expandirNodo. Esta funci�n la necesitan todas las b�squedas,
 * as� que saco factor com�n y luego, que la hereden.
 * @author alberto
 *
 */
public class ExpandNode {
	
	public ExpandNode() {}
	
	/**
	 * Dado un problema con sus funciones, y un nodo de espacio
	 * de b�squeda del mismo problema, que se supone reci�n sacado
	 * de la estructura de abiertos, esta funci�n lo expande,
	 * creando todos sus nodos hijos, y devolvi�ndolos en una 
	 * lista.
	 * @param n El nodo que se va a expandir.
	 * @param p El problema al que pertenece el nodo. Se necesita
	 * porque en �l se encuentra la funci�n sucesor que crear�
	 * los estados sucesores necesarios para crear los nodos hijos.
	 * @return Una lista de todos los nodos hijos resultado de
	 * expandir n.
	 */
	public Vector<Nodo> expandirNodo(Nodo n, Problema p) {
		Vector<Nodo> hijos=new Vector<Nodo>();
		hijos.clear();//preparamos la estructura de nodos hijos
		
		Vector<Sucesor> sucesores=p.getFunSucesor().getSucesores(n.getEstado());
		/*con esto tenemos un vector de estados sucesores de nodo n.
		 en cada uno, tenemos tambi�n el operador aplicado a n para llegar
		 Ahora, de cada uno tenemos que crear un nodo y a�adirlo a la lista.
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
