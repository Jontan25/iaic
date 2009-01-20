/**
 * 
 */
package com.iaic.problems.Planetas;

import problema.Problema;
import problemas.FuncionCosteStandard;
import estructurasDeDatos.Grafo;
import estructurasDeDatos.Planeta;

/**
 * @author alberto
 *
 */
public class planetasProblema extends Problema {
	private Grafo<Planeta> universo;
	
	public planetasProblema(planetasEstado ei) {
		super(ei,new planetasSucesor(),new planetasObjetivo(),new FuncionCosteStandard(),new planetasHeuristica());
		universo=new Grafo<Planeta>(216);
		inicializarUniverso();
		
	}
	
	/**
	 * En esta función se crean los planetas, y se agregan al grafo. Además
	 * hay que crear las aristas, cuya distancia es directamente
	 * proporcional a la dificultad del problema que se le asigna. Esto del
	 * problema que se le asigna se podría hacer con unas constantes static
	 * que fuesen en la estructura NodoAdyacencia, puesto que cada una de 
	 * esas estructuras representa una arista.
	 */
	private void inicializarUniverso() {
	
	}
}
