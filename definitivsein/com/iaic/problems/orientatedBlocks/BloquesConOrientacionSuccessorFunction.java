package com.iaic.problems.orientatedBlocks;
import java.util.List;
import java.util.Vector;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BloquesConOrientacionSuccessorFunction implements SuccessorFunction{

	public static String[] ACCIONES={"poner A en P","poner A en Q","girar A",
									"poner B en P","poner B en Q","girar B"};
	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	public List getSuccessors(Object estado) {
		List movimientos=new Vector();
		EstadoBloquesConOrientacion estadoBloques= (EstadoBloquesConOrientacion) estado;
		EstadoBloquesConOrientacion nuevoEstado;
		
		String posicionA=estadoBloques.dameSobreA();
		String posicionB=estadoBloques.dameSobreB();
		
		boolean verticalA=estadoBloques.dameVerticalA();
		boolean verticalB=estadoBloques.dameVerticalB();
		
		//obtenemos las cimas de las mesas que serán los unicos elementos que se podrán mover o girar
		String cimaP=estadoBloques.dameCima(EstadoBloquesConOrientacion.NOMBRES_MESAS[0]);
		String cimaQ=estadoBloques.dameCima(EstadoBloquesConOrientacion.NOMBRES_MESAS[1]);
		
		//Solo si la cima es un bloque podrá ser movida a otra posicion
		if (EstadoBloquesConOrientacion.esBloque(cimaP)){
			//Comprobamos que bloque esta en la cima P para saber que accion se utilizará (en este caso A)
			if (cimaP.equals(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[0])){
				try {
					//Se intenta pasar el bloque A a la cima de la otra mesa
					nuevoEstado=new EstadoBloquesConOrientacion(cimaQ,posicionB,verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				} catch (Exception e) {
				}
				try {
					//Se intenta girar el bloque A
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,posicionB,!verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				} catch (Exception e) {
				}
			//Se repite el proceso en este caso siendo la cima el bloque B
			}else if (cimaP.equals(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[1])){
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,cimaQ,verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[4],nuevoEstado));
				} catch (Exception e) {
				}
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,posicionB,verticalA,!verticalB);
					movimientos.add(new Successor(ACCIONES[5],nuevoEstado));
				} catch (Exception e) {
				}
			}
		}
		//Se repite el proceso para el resto de las mesas en este caso Q
		if (EstadoBloquesConOrientacion.esBloque(cimaQ)){
			if (cimaQ.equals(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[0])){
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(cimaP,posicionB,verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				} catch (Exception e) {
				}
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,posicionB,!verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				} catch (Exception e) {
				}
			}else if (cimaQ.equals(EstadoBloquesConOrientacion.NOMBRES_BLOQUES[1])){
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,cimaP,verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				} catch (Exception e) {
				}
				try {
					nuevoEstado=new EstadoBloquesConOrientacion(posicionA,posicionB,!verticalA,verticalB);
					movimientos.add(new Successor(ACCIONES[5],nuevoEstado));
				} catch (Exception e) {
				}
			}
		}
		return movimientos;
	}
}
