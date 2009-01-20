package com.iaic.problem.functionsInterfaces;
/**
 * La interfaz FuncionObjetivo representa a los diversos tests
 * que evaluarán si, dado un estado cualquiera, este es un estado
 * objetivo o no. Estos tests varían con el problema concreto,
 * por lo que se escoge una representación a alto nivel en forma
 * de interfaz, que cada problema tendrá que implementar con la
 * correspondiente función de evaluación del estado.
 * De esta forma, además, se pueden cambiar dinámicamente para
 * usar distintos criterios.
 * @author alberto
 *
 */
public interface FuncionObjetivo {
	/**
	 * Función que tendrá que implementarse para cada problema
	 * concreto, ya que para cada uno cambia no solo el criterio
	 * de evaluación del estado objetivo, sino la propia estructura
	 * del estado.
	 * @param candidato Representa el estado sobre el que queremos
	 * preguntar.
	 * @return True si el estado candidato es objetivo y False en
	 * caso contrario.
	 */
	public boolean esObjetivo(Object candidato);
}
