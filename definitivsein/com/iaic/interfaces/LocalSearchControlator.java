/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iaic.interfaces;



import java.awt.Window;
import java.awt.event.ActionEvent;

import com.iaic.searchs.Searches;
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
public class LocalSearchControlator extends ControladorBusqueda{
	private Problem problem;
	 
	public LocalSearchControlator(Problem problem){
		super();
		this.problem=problem;
	}
	
	public void actionPerformed(ActionEvent evento) {
		super.actionPerformed(evento);
		String accion=evento.getActionCommand();		
		if (accion.equals(ACCION_BUSCAR)){
		 		String estrategia=panel.dameEstrategia();
		 		Object parametro=panel.dameParametro();
		 		
		 		Search search=Searches.getSearch(estrategia,null,parametro);
		 		SearchAgent agent;
				try {
					agent = new SearchAgent(problem, search);
					if (Searches.finalizedSearch(search,agent.getActions())){
						finalizado=true;
						panel.añadirPanelDeInformacion(
								new PanelInformacionBusqueda("Solucion encontrada, se abrira la puerta",
															agent.getActions().toString(),
															agent.getInstrumentation().toString(),
															this));
					}else{
						if (search instanceof SimpleClimbingSearch ||
								search instanceof MaximumSlopeClimbingSearch){
								panel.añadirPanelDeInformacion(
										new PanelInformacionBusqueda("El algoritmo de escalada no encontro solución, se utilizará otra puerta",
																	agent.getActions().toString(),
																	this));
						}else if (search instanceof LimitedDepthSearch ||
								search instanceof IterativeDepthSearch){
							panel.añadirPanelDeInformacion(
									new PanelInformacionBusqueda("El algoritmo de profundidad (limitada o iterativa) no ha alcanzado solución, se utilizará otra puerta",
																agent.getActions().toString(),
																this));
						}else{		
								panel.añadirPanelDeInformacion(
									new PanelInformacionBusqueda("No se encontro solución, se utilizará otra puerta",this));
						}
					}		
				} catch (OutOfMemoryError e) {
					System.out.print("Excepcion en agent del Local");
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
