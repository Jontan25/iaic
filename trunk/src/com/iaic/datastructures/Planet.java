/**
 * 
 */
package com.iaic.datastructures;

/**
 * La representación de un planeta.
 * @author alberto
 *
 */
public class Planet {
	int idplaneta;
	boolean destino;
	
	public Planet() {}
	public Planet(int i) {
		idplaneta=i;destino=false;
	}
	
	public void hacerDestino() {
		destino=true;
	}
	
	public boolean esDestino() {
		return destino;
	}
	
	public Object clone() {
		Planet clone = new Planet(idplaneta);
		if (destino) clone.hacerDestino();
		return clone;
	}
	
	public String toString() {
		String p="p"+Integer.toString(idplaneta);
		return p;
	}
	
	public int hashCode() {
		return idplaneta;
	}
}
