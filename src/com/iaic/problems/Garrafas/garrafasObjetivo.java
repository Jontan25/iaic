/**
 * 
 */
package com.iaic.problems.Garrafas;
import problema.interfacesFunciones.FuncionObjetivo;
/**
 * @author alberto
 *
 */
public class garrafasObjetivo implements FuncionObjetivo {
	/*
	 * (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		garrafasEstado a=(garrafasEstado)candidato;
		return a.esObjetivo(); //en este hay que hacer este truquito
		//porque hay varios estados objetivos.
	}

}
