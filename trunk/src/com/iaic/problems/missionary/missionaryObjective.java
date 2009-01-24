/**
 * 
 */
package problems.missionary;;
import problema.interfacesFunciones.FuncionObjetivo;
/**
 * @author mario
 */
public class missionaryObjective implements FuncionObjetivo {
	/*
	 * (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionObjetivo#esObjetivo(java.lang.Object)
	 */
	@Override
	public boolean esObjetivo(Object candidato) {
		missionaryState a=(missionaryState)candidato;
		return a.esObjetivo(); //en este hay que hacer este truquito
		//porque hay varios estados objetivos.
	}

}
