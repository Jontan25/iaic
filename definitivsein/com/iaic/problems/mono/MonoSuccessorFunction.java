package com.iaic.problems.mono;
import java.util.List;
import java.util.Vector;

import aima.search.framework.StepCostFunction;
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
public class MonoSuccessorFunction implements SuccessorFunction{

	public static String[] ACCIONES={"mover mono a puerta ("+MonoStepCostFunction.COSTE_MOVERSE+")",
									"mover mono a centro ("+MonoStepCostFunction.COSTE_MOVERSE+")",
									"mover mono a ventana ("+MonoStepCostFunction.COSTE_MOVERSE+")",
									"mover caja a puerta ("+MonoStepCostFunction.COSTE_EMPUJAR+")",
									"mover caja a centro ("+MonoStepCostFunction.COSTE_EMPUJAR+")",
									"mover caja a ventana ("+MonoStepCostFunction.COSTE_EMPUJAR+")",
									"subir mono a caja ("+MonoStepCostFunction.COSTE_SUBIR+")",
									"bajar mono de caja ("+MonoStepCostFunction.COSTE_BAJAR+")"
									};
	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	public List getSuccessors(Object estado) {
		List movimientos=new Vector();
		EstadoMono estadoMono= (EstadoMono) estado;
		EstadoMono nuevoEstado;
		
		int posicionPlatano=estadoMono.damePosicionPlatano();
		int posicionCaja=estadoMono.damePosicionCaja();
		int posicionMono=estadoMono.damePosicionMono();
		boolean monoSobreCaja=estadoMono.estaMonoSobreCaja();
				
		if (posicionMono==EstadoMono.PUERTA){
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.CENTRO,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
			} catch (Exception e) {
			}			
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.VENTANA,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
			} catch (Exception e) {
			}
			if (posicionMono==posicionCaja){
				if (monoSobreCaja){
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,false);
						movimientos.add(new Successor(ACCIONES[7],nuevoEstado));
					} catch (Exception e) {
					}		
				}else{
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.CENTRO,EstadoMono.CENTRO,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[4],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.VENTANA,EstadoMono.VENTANA,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[5],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,true);
						movimientos.add(new Successor(ACCIONES[6],nuevoEstado));
					} catch (Exception e) {
					}
				}
				
			}
		}else if (posicionMono==EstadoMono.CENTRO){
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.PUERTA,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
			} catch (Exception e) {
			}
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.VENTANA,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
			} catch (Exception e) {
			}
			if (posicionMono==posicionCaja){
				if (monoSobreCaja){
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,false);
						movimientos.add(new Successor(ACCIONES[7],nuevoEstado));
					} catch (Exception e) {
					}
				}else{
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.PUERTA,EstadoMono.PUERTA,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.VENTANA,EstadoMono.VENTANA,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[5],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,true);
						movimientos.add(new Successor(ACCIONES[6],nuevoEstado));
					} catch (Exception e) {
					}
				}			
			}
			
		}else if (posicionMono==EstadoMono.VENTANA){
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.PUERTA,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
			} catch (Exception e) {
			}
			try {
				nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,EstadoMono.CENTRO,monoSobreCaja);
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
			} catch (Exception e) {
			}
			if (posicionMono==posicionCaja){
				if (monoSobreCaja){
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,false);
						movimientos.add(new Successor(ACCIONES[7],nuevoEstado));
					} catch (Exception e) {
					}
				}else{
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.PUERTA,EstadoMono.PUERTA,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,EstadoMono.CENTRO,EstadoMono.CENTRO,monoSobreCaja);
						movimientos.add(new Successor(ACCIONES[4],nuevoEstado));
					} catch (Exception e) {
					}
					try {
						nuevoEstado=new EstadoMono(posicionPlatano,posicionCaja,posicionMono,true);
						movimientos.add(new Successor(ACCIONES[6],nuevoEstado));
					} catch (Exception e) {
					}
				}
			}
		}
		return movimientos;
	}
}
