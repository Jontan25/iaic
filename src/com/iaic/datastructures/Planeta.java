/**
 * 
 */
package com.iaic.datastructures;

/**
 * La representación de un planeta.
 * @author alberto
 *
 */
public class Planeta {
	int idplaneta;
	boolean destino;
	
	public Planeta() {}
	public Planeta(int i) {
		idplaneta=i;destino=false;
	}
	
	public void hacerDestino() {
		destino=true;
	}
	
	public boolean esDestino() {
		return destino;
	}
	
	public Object clone() {
		Planeta clone = new Planeta(idplaneta);
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
