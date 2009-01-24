/**
 * 
 */
package problems.missionary;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCIÓN!!! FALTA DISEÑAR UNA HEURÍSTICA PARA PODERLE APLICAR
 * BÚSQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEURÍSTICA, PERO OJO CON EJECUTAR BÚSQUEDAS INFORMADAS CON ESTE.
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
