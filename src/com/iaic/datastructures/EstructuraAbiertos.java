/**
 * 
 */
package com.iaic.datastructures;
import problema.Nodo;
import java.util.Vector;

/**
 * Para todas las b�squedas se necesita tener una estructura de
 * nodos abiertos en la que guardamos los nodos que hemos expandido
 * pero no hemos visitado a�n (est�n pendientes de visitar).
 * Dependiendo del tipo de b�squeda concreta, esta estructura se
 * llena de una manera o de otra, y tiene unos atributos u otros.
 * 
 * A pesar de esto, se necesitan funciones para agregar y extraer 
 * nodos de la cola de abiertos, y para gestionarla. Para ello, se
 * definir�n en esta interfaz, y luego se implementar�n distintas
 * versiones de la cola de abiertos que las definir�n como sea
 * conveniente (pila, cola, cola de prioridad...)
 * @author alberto
 *
 */
public interface EstructuraAbiertos {
	/**
	 * Esta funci�n agrega un nodo a la estructura de abiertos.
	 * @param n nodo que se desea agregar a abiertos.
	 * @return True si no ha habido problemas.
	 */
	public boolean agregar(Nodo n);
	/**
	 * Esta funci�n extrae un nodo de la estructura de abiertos.
	 * @return El nodo extra�do.
	 */
	public Nodo extraer();
	/**
	 * Eval�a si la estructura de abiertos contiene nodos o no.
	 * @return True si est� vac�a.
	 */
	public boolean esVacia();
	/**
	 * 
	 * @return El n�mero de nodos de la estructura de abiertos.
	 */
	public int numNodos();
	/**
	 * Agrega una lista completa de nodos a la estructura. Es �til
	 * cuando se quiere agregar una lista completa de hijos en lugar
	 * de ir uno por uno.
	 * @param v Vector con la lista de nodos que se quiere agregar.
	 * @return True si no ha habido errores.
	 */
	public boolean agregar(Vector<Nodo> v);
}
