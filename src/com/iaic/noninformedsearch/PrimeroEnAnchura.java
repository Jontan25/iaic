/**
 * 
 */
package com.iaic.noninformedsearch;
import java.util.Vector;

import com.iaic.problem.Problem;

import busqueda.Busqueda;
import busqueda.ColaBusqueda;
import estructurasDeDatos.ColaAbiertos;


/**
 * En esta búsqueda, los nodos se expanden por orden no decreciente
 * de profundidad. Se expanden por niveles, por lo que no se necesita
 * vuelta atrás. Se usa una cola para la estructura de abiertos.
 * Es completa y óptima si el coste del camino es una función no
 * decreciente de la profundidad.
 * Suponiendo un factor máximo de ramificación r, y una profundidad
 * mínima hasta una solución p, el número de nodos expandidos es
 * r^p+1 -r. (Moore 1959)
 * @author alberto
 *
 */
public class PrimeroEnAnchura implements Busqueda {
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
	public PrimeroEnAnchura(ColaBusqueda c) {
		colaBusqueda=c;
	}
	
	
	public Vector<String> busqueda(Problem p) {
		return colaBusqueda.buscar(p,new OpenedQueue());
	}

}
