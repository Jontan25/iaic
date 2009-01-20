/**

 */
package com.iaic.problem.functionsInterfaces;

import problema.Sucesor;

/**
 * La interfaz FuncionSucesor se usar� para representar todas
 * las posibles funciones que generar�n los nodos hijos en cada
 * caso.
 * Como cada problema sigue unas normas espec�ficas para generar
 * los hijos que dependen de la configuraci�n del estado, y del
 * propio problema, se deja como interfaz con las funciones 
 * indicadas.
 * Luego, en cada problema, se tendr� que implementar una clase
 * que use esta interfaz para la funci�n espec�fica de sucesores.
 * @author alberto
 *
 */
public interface FuncionSucesor {
	/**
	 * Genera una lista de sucesores resultado de aplicar todos
	 * los operadores posibles al estado que se pasa por par�metro
	 * @param estado Estado al que aplicaremos los operadores
	 * @return Lista de sucesores
	 */
	public java.util.Vector<Sucesor> getSucesores(Object estado);

}
