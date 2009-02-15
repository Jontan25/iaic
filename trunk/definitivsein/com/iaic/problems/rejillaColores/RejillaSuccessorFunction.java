package com.iaic.problems.rejillaColores;
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
public class RejillaSuccessorFunction implements SuccessorFunction{

	public static String[] ACCIONES={"cambiar"};
	//En Este caso es un operador parametrizado con las posicion de la casilla que sera modificado
	//Por ejemplo, cambiar(1,2)
	
	public List getSuccessors(Object estado) {
		List movimientos=new Vector();
		EstadoRejilla estadoRejilla= (EstadoRejilla) estado;
		EstadoRejilla nuevoEstado;
		String accion;
		boolean[][]nuevaRejilla;
		for (int i=0;i<estadoRejilla.dameTamanoX();i++){
			for (int j=0;j<estadoRejilla.dameTamanoY();j++){
				try {
					nuevaRejilla=estadoRejilla.dameCopiaDeRejilla();
					nuevaRejilla[i][j]=!nuevaRejilla[i][j];
					nuevoEstado=new EstadoRejilla(nuevaRejilla);
					accion=ACCIONES[0]+"("+i+","+j+")";
					movimientos.add(new Successor(accion,nuevoEstado));
				} catch (Exception e) {
				}
			}
		}
		return movimientos;
	}
}
