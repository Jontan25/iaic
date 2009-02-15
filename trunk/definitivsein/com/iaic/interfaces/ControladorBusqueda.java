/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iaic.interfaces;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.iaic.searchs.Searches;




/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ControladorBusqueda implements ActionListener{
	public static final String ACCION_BUSCAR = "Buscar";
	public static final String ACCION_CONTINUAR = "Continuar";
	public static final String ACCION_SELECCIONAR = "Seleccionar Busqueda";
	
	protected boolean finalizado;
	protected PanelBusqueda panel;

	 
	public ControladorBusqueda(){
		super();
	}
	
	public void asociarPanel(PanelBusqueda panel){
		this.panel=panel;
	}
	
	public boolean finishSearch(){
		return finalizado;
	}
	
	public void actionPerformed(ActionEvent evento) {
		String accion=evento.getActionCommand();
		System.out.println(accion);
		if (accion.equals(ACCION_SELECCIONAR)){
			String estrategia=panel.dameEstrategia();
			if (estrategia.equals(Searches.SEARCH_TYPES[Searches.DEPTH]) ||
				estrategia.equals(Searches.SEARCH_TYPES[Searches.WIDTH]) ||
				estrategia.equals(Searches.SEARCH_TYPES[Searches.UNIFORM_COST]) ||
				estrategia.equals(Searches.SEARCH_TYPES[Searches.GREEDY])){
				panel.añadirPanelParametro(new PanelParametroCiclos(Searches.CONTROL_TYPES));
			}else if (estrategia.equals(Searches.SEARCH_TYPES[Searches.A_STAR])){
					panel.añadirPanelParametro(new PanelParametroCiclos(Searches.CONTROL_TYPES_A));
			}else if (estrategia.equals(Searches.SEARCH_TYPES[Searches.LIMITED_DEPTH])){
				panel.añadirPanelParametro(new PanelParametroLimite());
			}else{
				panel.quitarPanelParametro();
			}
		
		}else if (accion.equals(ACCION_CONTINUAR)){
			((Window) panel.getRootPane().getParent()).hide();
		}
		
		
	}	
}
