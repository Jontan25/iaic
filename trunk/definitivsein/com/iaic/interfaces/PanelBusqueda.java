/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iaic.interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.iaic.searchs.Searches;



/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PanelBusqueda extends JPanel{
	ControladorBusqueda controlador;
	
	protected JPanel panelDatos;
	protected JPanel panelTipoDeBusqueda;
	protected JComboBox estrategia;
	protected PanelParametrosBusqueda panelParametro;
	protected JButton boton;
	
	protected PanelInformacionBusqueda  panelInformacion;
	
	private static final int POSICION_ESTRATEGIA=0;
	private static final int POSICION_PARAMETRO=1;
	private static final int POSICION_BUSCAR=2;

	private static final int POSICION_DATOS=0;
	private static final int POSICION_TIPO_DE_BUSQUEDA=1;
	private static final int POSICION_INFORMACION=2;
	
	public PanelBusqueda(List datos){
		super();
	
		panelDatos=new JPanel();
		JLabel dato;
		JPanel panelDato;
		for (int i=0;i<datos.size();i++){
			panelDato=new JPanel();
			dato=new JLabel((String) datos.get(i));
			panelDato.add(dato);
			panelDatos.add(panelDato);
		}
		panelDatos.setLayout(new GridLayout(datos.size(),1));
		panelDatos.setBorder(new TitledBorder("INFORMACION DEL JUEGO"));
		//panelDatos.setBorder(new EtchedBorder());
		//panelDatos.setBorder(new BevelBorder(BevelBorder.LOWERED));
		//panelDatos.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		
		JLabel etiquetaEstrategia=new JLabel("Seleccionar un método de com.iaic.searchs: ");
		estrategia=new JComboBox(Searches.SEARCH_TYPES);
		JPanel panelEstrategia=new JPanel();
		panelEstrategia.add(etiquetaEstrategia);
		panelEstrategia.add(estrategia);
		
		boton=new JButton(ControladorBusqueda.ACCION_BUSCAR);
		JPanel panelBoton=new JPanel();
		panelBoton.add(boton);
	
		panelTipoDeBusqueda=new JPanel();
		panelTipoDeBusqueda.setLayout(new GridLayout(2,1));
		panelTipoDeBusqueda.add(panelEstrategia);
		panelTipoDeBusqueda.add(panelBoton);
		panelTipoDeBusqueda.setBorder(new TitledBorder("METODO DE BUSQUEDA"));
		
		this.setLayout(new BorderLayout());
		this.add(panelDatos,BorderLayout.NORTH);
		this.add(panelTipoDeBusqueda,BorderLayout.CENTER);
	}
	
	public void associateController(ControladorBusqueda controlador){
		this.controlador=controlador;
		controlador.asociarPanel(this);
		boton.addActionListener(controlador);
		estrategia.addActionListener(controlador);
		estrategia.setActionCommand(ControladorBusqueda.ACCION_SELECCIONAR);
		estrategia.setSelectedIndex(0);	
	}

	public String dameEstrategia() {
		return (String) estrategia.getSelectedItem();
	}
	
	public Object dameParametro(){
		Object parametro=null;
		if (panelParametro!=null){
			parametro=panelParametro.dameParametro();
		}
		return parametro;
	}
		
	public void añadirPanelParametro(PanelParametrosBusqueda panelParametro){
		panelTipoDeBusqueda.setLayout(new GridLayout(3,1));
		if (this.panelParametro!=null){
			panelTipoDeBusqueda.remove(POSICION_PARAMETRO);
		}
		panelTipoDeBusqueda.add(panelParametro,POSICION_PARAMETRO);
		this.panelParametro=panelParametro;
		this.repaint();
		((Window) this.getRootPane().getParent()).pack();
		
	}
	
	public void quitarPanelParametro() {
		panelTipoDeBusqueda.setLayout(new GridLayout(2,1));
		if (this.panelParametro!=null){
			panelTipoDeBusqueda.remove(POSICION_PARAMETRO);
		}
		this.panelParametro=null;
		this.repaint();
		((Window) this.getRootPane().getParent()).pack();
		
		
	}	
	public void añadirPanelDeInformacion(PanelInformacionBusqueda panelInformacion){
		if (this.panelInformacion!=null){
			this.remove(POSICION_INFORMACION);
		}
		this.add(panelInformacion,BorderLayout.SOUTH);
		this.panelInformacion=panelInformacion;
		this.repaint();
		((Window) this.getRootPane().getParent()).pack();
		
		
	}

	
	
}
