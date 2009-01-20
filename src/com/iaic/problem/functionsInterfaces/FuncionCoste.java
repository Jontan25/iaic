/**
 * 
 */
package com.iaic.problem.functionsInterfaces;

/**
 * La interfaz FuncionCoste se usará para representar las diversas
 * funciones de coste o distancia que se podrán usar. La función de
 * coste para pasar de un estado a otro depende de problema concreto
 * e incluso del estado. Pero además, incluso para un mismo problema,
 * puede interesarnos tener varias funciones de coste y usar una en
 * cada ejecución para evaluar distintos criterios. Por esta razón se
 * escoge una interfaz de representación, que implementará luego cada
 * problema con sus funciones de coste específicas.
 * @author alberto
 *
 */
public interface FuncionCoste {
	/**
	 * Esta función habrá que implementarla para cada problema, ya
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
