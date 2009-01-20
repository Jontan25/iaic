
package com.iaic.datastructures;

/**
 * The representation of a planet
 * @author jose, mario
 *
 */
public class Planet {
	int idplanet;
	boolean destiny;
	
	public Planet() {}
	public Planet(int i) {
		idplanet=i;destiny=false;
	}
	
	public void makeDestiny() {
		destiny=true;
	}
	
	public boolean isDestiny() {
		return destiny;
	}
	
	public Object clone() {
		Planet clone = new Planet(idplanet);
		if (destiny) clone.makeDestiny();
		return clone;
	}
	
	public String toString() {
		String p="p"+Integer.toString(idplanet);
		return p;
	}
	
	public int hashCode() {
		return idplanet;
	}
}
