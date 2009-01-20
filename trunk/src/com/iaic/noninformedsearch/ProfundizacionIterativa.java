/**
 * 
 */
package com.iaic.noninformedsearch;
import busqueda.Busqueda;
import problema.Problema;
import java.util.Vector;

/**
 * Esta búsqueda está muy relacionada con la búsqueda
 * de profundidad limitada. Se trata de hacer diversas
 * búsquedas de profundidad limitada, aumentando cada
 * vez el límite de profundidad, hasta encontrar una
 * solución satisfactoria.
 * @author alberto
 *
 */
public class ProfundizacionIterativa implements Busqueda {
	/**
	 * El máximo límite de profundidad con la que se harán
	 * las búsquedas de profundidad limitada.
	 */
	private final int LIMITE=9999;
	
	/**
	 * Hace un bucle para hacer distintas búsquedas de
	 * profundidad limitada hasta que se encuentra una 
	 * solución, o hasta que se alcanza un límite de
	 * profundidad demasiado alto.
	 */
	public Vector<String> busqueda(Problema p) {
		Vector<String> sol=new Vector<String>();
		sol.clear();
		for (int i=1;i<=LIMITE;i++) {
			ProfundidadLimitada b=new ProfundidadLimitada(i);
			sol=b.busqueda(p);
			if (!sol.isEmpty())
				return sol;
		}
		return new Vector<String>();
	}
}
