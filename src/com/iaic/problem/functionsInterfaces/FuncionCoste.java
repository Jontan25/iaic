/**
 * 
 */
package com.iaic.problem.functionsInterfaces;

/**
 * La interfaz FuncionCoste se usar� para representar las diversas
 * funciones de coste o distancia que se podr�n usar. La funci�n de
 * coste para pasar de un estado a otro depende de problema concreto
 * e incluso del estado. Pero adem�s, incluso para un mismo problema,
 * puede interesarnos tener varias funciones de coste y usar una en
 * cada ejecuci�n para evaluar distintos criterios. Por esta raz�n se
 * escoge una interfaz de representaci�n, que implementar� luego cada
 * problema con sus funciones de coste espec�ficas.
 * @author alberto
 *
 */
public interface FuncionCoste {
	/**
	 * Esta funci�n habr� que implementarla para cada problema, ya
	 * que depende del problema y los criterios concretos que
	 * queramos aplicar, y del operador.
	 * @param estado1 Estado inicial.
	 * @param estado2 Estado destino.
	 * @param operador Operador aplicado para ir de estado1 a estado2.
	 * @return El coste del viaje desde estado1 hasta estado2 usando
	 * el operador indicado.
	 */
	public double calcularCoste(Object estado1,Object estado2,String operador);
}
