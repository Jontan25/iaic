/**

 */
package com.iaic.problem.functionsInterfaces;

import problema.Sucesor;

/**
 * La interfaz FuncionSucesor se usará para representar todas
 * las posibles funciones que generarán los nodos hijos en cada
 * caso.
 * Como cada problema sigue unas normas específicas para generar
 * los hijos que dependen de la configuración del estado, y del
 * propio problema, se deja como interfaz con las funciones 
 * indicadas.
 * Luego, en cada problema, se tendrá que implementar una clase
 * que use esta interfaz para la función específica de sucesores.
 * @author alberto
 *
 */
public interface FuncionSucesor {
	/**
	 * Genera una lista de sucesores resultado de aplicar todos
	 * los operadores posibles al estado que se pasa por parámetro
	 * @param estado Estado al que aplicaremos los operadores
	 * @return Lista de sucesores
	 */
	public java.util.Vector<Sucesor> getSucesores(Object estado);

}
