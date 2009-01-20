package com.iaic.problem.functionsInterfaces;

/**
 * La interfaz FuncionHeuristica representa a todas las funciones
 * heur�sticas, que en cada problema habr� que personalizarlas para
 * adaptarlas a nuestras estimaciones. Solo se usar�n en las
 * b�squedas informadas. Cada problema podr� implementar una o 
 * varias funciones heur�sticas atendiendo a los criterios que se
 * deseen, aunque solo podr� usar una a la vez. Esto se indicar�
 * al instanciar el problema, y se usar� solo en la b�squeda,
 * pudiendo hacer diversas b�squedas don distintas funciones 
 * heur�sticas y comparar.
 * @author alberto
 *
 */
public interface FuncionHeuristica {

	/**
	 * Se implementar� una o varias para cada problema, atendiendo
	 * al criterio que se desee, y a la propia estructura del 
	 * estado. El valor que devuelve representa una estimaci�n
	 * m�s o menos precisa en funci�n del criterio de lo que puede
	 * costar llegar a un estado objetivo si estamos en "estado".
	 * Hay que destacar que esta estimaci�n no tiene NADA que ver
	 * con los nodos, sino con el estado.
	 * @param estado El estado desde el que preguntamos la
	 * estimaci�n
	 * @return La estimaci�n del coste para llegar desde estado
	 * a un estado objetivo.
	 */
	public double valorHeuristico(Object estado);
}
