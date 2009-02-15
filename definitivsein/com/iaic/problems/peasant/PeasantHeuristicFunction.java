package com.iaic.problems.peasant;

import aima.search.framework.HeuristicFunction;

public class PeasantHeuristicFunction implements HeuristicFunction{
	public static final String DESCRIPCION="Distancia Manhattan - Suma de los movimientos de cada elemento (granjero,lobo,oveja y col) hasta el objetivo";
	
	PeasantState estadoFinal;
	
	public PeasantHeuristicFunction(PeasantState estadoFinal) {
		this.estadoFinal=estadoFinal;		
	}

	public double getHeuristicValue(Object state) {
		PeasantState peasantState=(PeasantState) state;
			
		int valor=0;
		if (peasantState.dameLobo()!=estadoFinal.dameLobo()){
			valor=valor+PeasantStepCostFunction.COSTE_LOBO;
		}
		
		if (peasantState.dameOveja()!=estadoFinal.dameOveja()){
			valor=valor+PeasantStepCostFunction.COSTE_OVEJA;
		}
		
		if (peasantState.dameCol()!=estadoFinal.dameCol()){
			valor=valor+PeasantStepCostFunction.COSTE_COL;
		}
		
		if (peasantState.dameGranjero()!=estadoFinal.dameGranjero()){
			valor=valor+PeasantStepCostFunction.COSTE_GRANJERO;
		}
		
		return valor;
	}

	
}
