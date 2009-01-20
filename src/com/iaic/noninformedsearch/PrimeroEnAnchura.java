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
 * En esta b�squeda, los nodos se expanden por orden no decreciente
 * de profundidad. Se expanden por niveles, por lo que no se necesita
 * vuelta atr�s. Se usa una cola para la estructura de abiertos.
 * Es completa y �ptima si el coste del camino es una funci�n no
 * decreciente de la profundidad.
 * Suponiendo un factor m�ximo de ramificaci�n r, y una profundidad
 * m�nima hasta una soluci�n p, el n�mero de nodos expandidos es
 * r^p+1 -r. (Moore 1959)
 * @author alberto
 *
 */
public class PrimeroEnAnchura implements Busqueda {
	/**
	 * Cualquiera que herede de ColaBusqueda. Si usamos un
	 * GrafoBusqueda, por ejemplo, el m�todo buscar tendr� control
	 * de ciclos y ser� m�s eficiente.
	 */
	ColaBusqueda colaBusqueda;
	/**
	 * Metemos la ColaBusqueda desde fuera porque as� podemos 
	 * elegir entre implementar control de ciclos o no. La misma
	 * b�squeda nos sirve para los dos casos.
	 * @param c La estructura que usaremos como cola de b�squeda.
	 */
	public PrimeroEnAnchura(ColaBusqueda c) {
		colaBusqueda=c;
	}
	
	
	public Vector<String> busqueda(Problem p) {
		return colaBusqueda.buscar(p,new OpenedQueue());
	}

}
