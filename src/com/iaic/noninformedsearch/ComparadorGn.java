/**
 * 
 */
package com.iaic.noninformedsearch;

import java.util.Comparator;
import problema.Nodo;

/**
 * Un comparador basándose en la función de coste. Tiene en cuenta
 * el coste total para llegar desde la raiz al nodo.
 * Se usa en la búsqueda de coste uniforme, por ejemplo.
 * @author alberto
 *
 */
public class ComparadorGn implements Comparator<Nodo> {
	
	public int compare(Nodo uno,Nodo dos) {
			return uno.getCosteTotalD().compareTo(dos.getCosteTotalD());
	}
}
