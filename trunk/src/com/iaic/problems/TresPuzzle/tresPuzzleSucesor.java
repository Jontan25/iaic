/**
 * El problema de 3-puzzle no siempre tiene solución. Muevas como
 * muevas el hueco, solo se permite rotar las piezas, bien en sentido
 * de las agujas del reloj o en sentido contrario, por lo que,
 * si las piezas están cruzadas es imposible colocarlas en orden
 * correcto. Esto lo diferencia del 8-puzzle.
 */
package com.iaic.problems.TresPuzzle;

import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;

/**
 * @author alberto
 *
 */
public class tresPuzzleSucesor implements FuncionSucesor {
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
		tresPuzzleEstado estadoActual=(tresPuzzleEstado)estado;
		if (estadoActual.puedoMoverArriba()) {
			tresPuzzleEstado arriba=(tresPuzzleEstado)estadoActual.clone();
			arriba.moverArriba();
			sucesores.add(new Sucesor(arriba,OPARRIBA));
		} //para el movimiento hacia arriba
		
		if (estadoActual.puedoMoverAbajo()) {
			tresPuzzleEstado abajo=(tresPuzzleEstado)estadoActual.clone();
			abajo.moverAbajo();
			sucesores.add(new Sucesor(abajo,OPABAJO));
		}//para el movimiento hacia abajo

		if (estadoActual.puedoMoverIzquierda()) {
			tresPuzzleEstado izquierda=(tresPuzzleEstado)estadoActual.clone();
			izquierda.moverIzquierda();
			sucesores.add(new Sucesor(izquierda,OPIZQUIERDA));
		}//para el movimiento hacia la izquierda
		
		if (estadoActual.puedoMoverDerecha()) {
			tresPuzzleEstado derecha=(tresPuzzleEstado)estadoActual.clone();
			derecha.moverDerecha();
			sucesores.add(new Sucesor(derecha,OPDERECHA));
		} //y el cuarto operador, movimiento a la derecha
		return sucesores;
	}
	
	
}
