/**
 * 
 */
package com.iaic.problems.Garrafas;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCIÓN!!! FALTA DISEÑAR UNA HEURÍSTICA PARA PODERLE APLICAR
 * BÚSQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEURÍSTICA, PERO OJO CON EJECUTAR BÚSQUEDAS INFORMADAS CON ESTE.
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
