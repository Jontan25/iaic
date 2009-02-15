package com.iaic.problems.mono;

import aima.search.framework.HeuristicFunction;

public class MonoHeuristicFunction implements HeuristicFunction{

	
	private EstadoMono estadoFinal;
	public MonoHeuristicFunction(EstadoMono estadoFinal) throws Exception {
		super();
		this.estadoFinal=estadoFinal;
		if (estadoFinal.damePosicionMono()!=estadoFinal.damePosicionPlatano()
			|| !estadoFinal.estaMonoSobreCaja()){
			throw new Exception("Esta heuristica debe trabajar con estados finales en los que el mono coge el platano");
		}
	}

	public double getHeuristicValue(Object state) {
		EstadoMono estadoMono=(EstadoMono) state;
		
		//int posicionPlatano=estadoMono.damePosicionPlatano();
		int posicionCaja=estadoMono.damePosicionCaja();
		int posicionMono=estadoMono.damePosicionMono();
		boolean monoSobreCaja=estadoMono.estaMonoSobreCaja();
		
		int posicionPlatanoFinal=estadoFinal.damePosicionPlatano();
		//int posicionCajaFinal=_finalState.damePosicionCaja();
		//int posicionMonoFinal=_finalState.damePosicionMono();
		//boolean monoSobreCajaFinal=_finalState.estaMonoSobreCaja();
		
		int valor=0;
		
		if (posicionMono!=posicionPlatanoFinal && monoSobreCaja){
			valor++;
		}
		if (posicionMono!=posicionCaja){
			valor=valor+2;
		}
		
		if (posicionPlatanoFinal!=posicionCaja){
			valor=valor+3;
		}
		
		if (posicionPlatanoFinal!=posicionMono || !monoSobreCaja){
			valor=valor+4;
		}
		
		return valor;
	}

	
}
