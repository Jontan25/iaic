/**
 * 
 */
package problems.missionary;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCI�N!!! FALTA DISE�AR UNA HEUR�STICA PARA PODERLE APLICAR
 * B�SQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEUR�STICA, PERO OJO CON EJECUTAR B�SQUEDAS INFORMADAS CON ESTE.
 * @author mario
 *
 */
public class missionaryProblem extends Problema {
	/**
	 * 
	 * @param e El estado inicial del problema.
	 */
	public missionaryProblem(missionaryState e) {
		super(e,new misionarySuccesor(),new missionaryObjective(),new FuncionCosteStandard(),null);
	}
}
