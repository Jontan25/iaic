/**
 * 
 */
package com.iaic.problems.Planetas;
import estructurasDeDatos.Planeta;
import estructurasDeDatos.Grafo;
import estructurasDeDatos.NodoAdyacencia;
import java.util.LinkedList;

/**
 * @author alberto
 *
 */
public class planetasEstado {
	Planeta planeta;
	Grafo<Planeta> universo;
	
	public planetasEstado() {
		planeta=null;universo=null;
	}
	
	public planetasEstado(Planeta p,Grafo<Planeta> g) {
		planeta=p; universo=g;
	}
	
	public boolean esObjetivo() {
		return planeta.esDestino();
	}
	
	public void hacerEstadoInicial() {}
	
	public void hacerObjetivo() {
		planeta.hacerDestino();
	}
	
	public String toString() {
		return planeta.toString();
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		planetasEstado clone=new planetasEstado((Planeta)planeta.clone(),universo);
		return clone;
	}
	
	public int hashCode() {
		return planeta.hashCode();
	}
	
	public LinkedList<NodoAdyacencia<Planeta>> getAdyacentes() {
		return universo.adyacentes(planeta);
	}
	
	public void moverseA(Planeta d) {
		planeta=d;
	}
}
