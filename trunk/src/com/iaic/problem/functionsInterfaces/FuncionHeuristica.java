package com.iaic.problem.functionsInterfaces;

/**
 * La interfaz FuncionHeuristica representa a todas las funciones
 * heurísticas, que en cada problema habrá que personalizarlas para
 * adaptarlas a nuestras estimaciones. Solo se usarán en las
 * búsquedas informadas. Cada problema podrá implementar una o 
 * varias funciones heurísticas atendiendo a los criterios que se
 * deseen, aunque solo podrá usar una a la vez. Esto se indicará
 * al instanciar el problema, y se usará solo en la búsqueda,
 * pudiendo hacer diversas búsquedas don distintas funciones 
 * heurísticas y comparar.
 * @author alberto
 *
 */
public interface FuncionHeuristica {

	/**
	 * Se implementará una o varias para cada problema, atendiendo
	 * al criterio que se desee, y a la propia estructura del 
	 * estado. El valor que devuelve representa una estimación
	 * más o menos precisa en función del criterio de lo que puede
	 * costar llegar a un estado objetivo si estamos en "estado".
	 * Hay que destacar que esta estimación no tiene NADA que ver
	 * con los nodos, sino con el estado.
	 * @param estado El estado desde el que preguntamos la
	 * estimación
	 * @return La estimación del coste para llegar desde estado
	 * a un estado objetivo.
	 */
	public double valorHeuristico(Object estado);
}
