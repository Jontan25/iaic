/**
 * 
 */
package com.iaic.noninformedsearch;
import busqueda.Busqueda;
import problema.Problema;
import java.util.Vector;

/**
 * Esta b�squeda est� muy relacionada con la b�squeda
 * de profundidad limitada. Se trata de hacer diversas
 * b�squedas de profundidad limitada, aumentando cada
 * vez el l�mite de profundidad, hasta encontrar una
 * soluci�n satisfactoria.
 * @author alberto
 *
 */
public class ProfundizacionIterativa implements Busqueda {
	/**
	 * El m�ximo l�mite de profundidad con la que se har�n
	 * las b�squedas de profundidad limitada.
	 */
	private final int LIMITE=9999;
	
	/**
	 * Hace un bucle para hacer distintas b�squedas de
	 * profundidad limitada hasta que se encuentra una 
	 * soluci�n, o hasta que se alcanza un l�mite de
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
