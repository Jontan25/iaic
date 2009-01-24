/**
 * 
 */
package problems.farmerandlettuce;
import problema.interfacesFunciones.FuncionObjetivo;
/**
 * @author mario
 */
public class farmerandlettuceObjective implements FuncionObjetivo {
	/*
	 * (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		farmerandlettuceState a=(farmerandlettuceState)candidato;
		return a.esObjetivo(); //en este hay que hacer este truquito
		//porque hay varios estados objetivos.
	}

}
