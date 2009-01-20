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
 * En esta b�squeda, en cada paso, se visita un nodo
 * sucesor del nodo anterior, por lo que necesitamos
 * una estructura que nos permita hacer vuelta atr�s,
 * y para eso usamos una pila.
 * Esta b�squeda no es completa ni �ptima, y no es
 * recomendable si la m�xima profundidad del �rbol es
 * grande. Sin embargo, es m�s econ�mica en espacio que
 * b�squedas como la de primero en anchura, por ejemplo.
 * @author alberto
 *
 */
public class PrimeroEnProfundidad implements Busqueda {
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
