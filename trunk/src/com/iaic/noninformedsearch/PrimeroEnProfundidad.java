/**
 * 
 */
package com.iaic.noninformedsearch;

import java.util.Vector;

import com.iaic.problem.Problem;

import estructurasDeDatos.PilaAbiertos;
import busqueda.Busqueda;
import busqueda.ColaBusqueda;
/**
 * En esta búsqueda, en cada paso, se visita un nodo
 * sucesor del nodo anterior, por lo que necesitamos
 * una estructura que nos permita hacer vuelta atrás,
 * y para eso usamos una pila.
 * Esta búsqueda no es completa ni óptima, y no es
 * recomendable si la máxima profundidad del árbol es
 * grande. Sin embargo, es más económica en espacio que
 * búsquedas como la de primero en anchura, por ejemplo.
 * @author alberto
 *
 */
public class PrimeroEnProfundidad implements Busqueda {
	/**
	 * Cualquiera que herede de ColaBusqueda. Si usamos un
	 * GrafoBusqueda, por ejemplo, el método buscar tendrá control
	 * de ciclos y será más eficiente.
	 */
	ColaBusqueda colaBusqueda;
	/**
	 * Metemos la ColaBusqueda desde fuera porque así podemos 
	 * elegir entre implementar control de ciclos o no. La misma
	 * búsqueda nos sirve para los dos casos.
	 * @param c La estructura que usaremos como cola de búsqueda.
	 */
	public PrimeroEnProfundidad(ColaBusqueda c) {
		colaBusqueda=c;
	}
	
	/* (non-Javadoc)
	 * @see busqueda.Busqueda#busqueda(problema.Problema)
	 */
	public Vector<String> busqueda(Problem p) {
		return colaBusqueda.buscar(p,new OpenedStack());
	}

}
