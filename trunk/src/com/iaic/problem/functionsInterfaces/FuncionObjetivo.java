package com.iaic.problem.functionsInterfaces;
/**
 * La interfaz FuncionObjetivo representa a los diversos tests
 * que evaluar�n si, dado un estado cualquiera, este es un estado
 * objetivo o no. Estos tests var�an con el problema concreto,
 * por lo que se escoge una representaci�n a alto nivel en forma
 * de interfaz, que cada problema tendr� que implementar con la
 * correspondiente funci�n de evaluaci�n del estado.
 * De esta forma, adem�s, se pueden cambiar din�micamente para
 * usar distintos criterios.
 * @author alberto
 *
 */
public interface FuncionObjetivo {
	/**
	 * Funci�n que tendr� que implementarse para cada problema
	 * concreto, ya que para cada uno cambia no solo el criterio
	 * de evaluaci�n del estado objetivo, sino la propia estructura
	 * del estado.
	 * @param candidato Representa el estado sobre el que queremos
	 * preguntar.
	 * @return True si el estado candidato es objetivo y False en
	 * caso contrario.
	 */
	public boolean esObjetivo(Object candidato);
}
