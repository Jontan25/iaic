/**
 * 
 */
package com.iaic.problems.Planetas;

import java.util.ListIterator;
import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;
import java.util.LinkedList;
import estructurasDeDatos.NodoAdyacencia;
import estructurasDeDatos.Planeta;

/**
 * @author alberto
 *
 */
public class planetasSucesor implements FuncionSucesor {

	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionSucesor#getSucesores(java.lang.Object)
	 */
	@Override
	public Vector<Sucesor> getSucesores(Object estado) {
		Vector<Sucesor> sucesores=new Vector<Sucesor>();
		sucesores.clear();
		planetasEstado estadoActual=(planetasEstado)estado;
		
		LinkedList<NodoAdyacencia<Planeta>> adyacentes=estadoActual.getAdyacentes();
		int numAdyacentes=adyacentes.size();
		for (NodoAdyacencia<Planeta> nd:adyacentes) {
			planetasEstado e=(planetasEstado)nd.getElemento().clone();
			e.moverseA(nd.getElemento());
			sucesores.add(new Sucesor(e,e.toString()));
		}
		
		return sucesores;
	}

}
