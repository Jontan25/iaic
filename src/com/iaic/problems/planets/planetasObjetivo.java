/**
 * 
 */
package com.iaic.problems.Planetas;

import problema.interfacesFunciones.FuncionObjetivo;

/**
 * @author alberto
 *
 */
public class planetasObjetivo implements FuncionObjetivo {

	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		planetasEstado c=(planetasEstado)candidato;
		return c.esObjetivo();
	}

}
