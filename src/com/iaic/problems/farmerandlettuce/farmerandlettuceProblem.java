/**
 * 
 */
package problems.farmerandlettuce;

import problema.Problema;
import problemas.FuncionCosteStandard;

/**
 * ATENCIÓN!!! FALTA DISEÑAR UNA HEURÍSTICA PARA PODERLE APLICAR
 * BÚSQUEDAS INFORMADAS. DE MOMENTO LE PASO NULL A LA REFERENCIA A 
 * LA HEURÍSTICA, PERO OJO CON EJECUTAR BÚSQUEDAS INFORMADAS CON ESTE.
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
