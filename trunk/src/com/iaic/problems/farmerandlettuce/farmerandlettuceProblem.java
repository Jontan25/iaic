/**
 * 
 */
package problems.farmerandlettuce;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCI�N!!! FALTA DISE�AR UNA HEUR�STICA PARA PODERLE APLICAR
 * B�SQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEUR�STICA, PERO OJO CON EJECUTAR B�SQUEDAS INFORMADAS CON ESTE.
 * @author mario
 *
 */
public class farmerandlettuceProblem extends Problema {
	/**
	 * 
	 * @param e El estado inicial del problema.
	 */
	public misionerosProblema(misionerosEstado e) {
		super(e,new misionerosSucesor(),new misionerosObjetivo(),new FuncionCosteStandard(),null);
	}
}
