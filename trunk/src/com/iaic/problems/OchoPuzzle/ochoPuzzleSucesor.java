/**
 * 
 */
package com.iaic.problems.OchoPuzzle;

import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;

/**
 * @author alberto
 *
 */
public class ochoPuzzleSucesor implements FuncionSucesor {
	private final String OPARRIBA="ARRIBA";
	private final String OPABAJO="ABAJO";
	private final String OPIZQUIERDA="IZQUIERDA";
	private final String OPDERECHA="DERECHA";
	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionSucesor#getSucesores(java.lang.Object)
	 */
	@Override
	public Vector<Sucesor> getSucesores(Object estado) {
		Vector<Sucesor> sucesores=new Vector<Sucesor>();
		sucesores.clear();
		ochoPuzzleEstado estadoActual=(ochoPuzzleEstado)estado;
		if (estadoActual.puedoMoverArriba()) {
			ochoPuzzleEstado arriba=(ochoPuzzleEstado)estadoActual.clone();
			arriba.moverArriba();
			sucesores.add(new Sucesor(arriba,OPARRIBA));
		} //para el movimiento hacia arriba
		
		if (estadoActual.puedoMoverAbajo()) {
			ochoPuzzleEstado abajo=(ochoPuzzleEstado)estadoActual.clone();
			abajo.moverAbajo();
			sucesores.add(new Sucesor(abajo,OPABAJO));
		}//para el movimiento hacia abajo

		if (estadoActual.puedoMoverIzquierda()) {
			ochoPuzzleEstado izquierda=(ochoPuzzleEstado)estadoActual.clone();
			izquierda.moverIzquierda();
			sucesores.add(new Sucesor(izquierda,OPIZQUIERDA));
		}//para el movimiento hacia la izquierda
		
		if (estadoActual.puedoMoverDerecha()) {
			ochoPuzzleEstado derecha=(ochoPuzzleEstado)estadoActual.clone();
			derecha.moverDerecha();
			sucesores.add(new Sucesor(derecha,OPDERECHA));
		} //y el cuarto operador, movimiento a la derecha
		return sucesores;
	}
	
	
}
