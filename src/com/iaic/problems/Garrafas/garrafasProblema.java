/**
 * 
 */
package com.iaic.problems.Garrafas;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCI�N!!! FALTA DISE�AR UNA HEUR�STICA PARA PODERLE APLICAR
 * B�SQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEUR�STICA, PERO OJO CON EJECUTAR B�SQUEDAS INFORMADAS CON ESTE.
 * @author alberto
 *
 */
public class garrafasProblema extends Problema {
	/**
	 * 
	 * @param e El estado inicial del problema.
	 */
	public garrafasProblema(garrafasEstado e) {
		super(e,new garrafasSucesor(),new garrafasObjetivo(),new FuncionCosteStandard(),null);
	}
}
