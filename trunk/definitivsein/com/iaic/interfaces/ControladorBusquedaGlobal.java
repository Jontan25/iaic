/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iaic.interfaces;


import java.awt.event.ActionEvent;

import com.iaic.problems.cube.CubeConditionTest;
import com.iaic.problems.cube.CubeGoalTest;
import com.iaic.problems.cube.CubeHeuristicFunction;
import com.iaic.problems.cube.CubeState;
import com.iaic.problems.cube.CubeStepCostFunction;
import com.iaic.problems.cube.CubeSuccessorFunction;
import com.iaic.searchs.Searches;
import com.iaic.searchs.ConditionTest;
import com.iaic.searchs.MaximumSlopeClimbingSearch;
import com.iaic.searchs.SimpleClimbingSearch;
import com.iaic.searchs.IterativeDepthSearch;
import com.iaic.searchs.LimitedDepthSearch;




import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ControladorBusquedaGlobal extends ControladorBusqueda{
	public ControladorBusquedaGlobal(){
		super();
	}
	
	public void actionPerformed(ActionEvent evento) {
		super.actionPerformed(evento);
		String accion=evento.getActionCommand();
		if (accion.equals(ACCION_BUSCAR)){
			String estrategia=panel.dameEstrategia();
			Object parametro=panel.dameParametro();
			System.out.println("\nLaberito Cúbico -->");
		 		Problem problem =  new Problem(new CubeState(),
					new CubeSuccessorFunction(), new CubeGoalTest(),
					new CubeStepCostFunction(), new CubeHeuristicFunction());
				ConditionTest conditionTest=new CubeConditionTest();
				
				Search search = Searches.getSearch(estrategia,conditionTest,parametro);				
				SearchAgent agent;
				try { 
					agent= new SearchAgent(problem, search);
					if (Searches.finalizedSearch(search,agent.getActions())){
						finalizado=true;
						panel.añadirPanelDeInformacion(
							new PanelInformacionBusqueda("Busqueda Global terminada",
														agent.getActions().toString(),
														agent.getInstrumentation().toString(),
														this));
					}else{
						finalizado=false;
						if (search instanceof SimpleClimbingSearch ||
								search instanceof MaximumSlopeClimbingSearch){
								panel.añadirPanelDeInformacion(
										new PanelInformacionBusqueda("El algoritmo de escalada no encontro solución",
																	agent.getActions().toString(),
																	this));
						}else if (search instanceof LimitedDepthSearch ||
								search instanceof IterativeDepthSearch){
							panel.añadirPanelDeInformacion(
									new PanelInformacionBusqueda("El algoritmo de profundidad (limitada o iterativa) no ha alcanzado solución",
																agent.getActions().toString(),
																this));
						}else{		
								panel.añadirPanelDeInformacion(
									new PanelInformacionBusqueda("No se encontro solución",this));
						}
					}

				}catch (OutOfMemoryError e){
					System.out.print("OutOfMemoryError en agent del Global");
					e.printStackTrace();
					finalizado=false;
					panel.añadirPanelDeInformacion(
							new PanelInformacionBusqueda("No se encontro solucion por falta de memoria, se utilizara otra puerta",
														this));
		
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}
	}	
}
