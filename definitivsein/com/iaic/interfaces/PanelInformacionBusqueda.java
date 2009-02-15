package com.iaic.interfaces;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.*;


public class PanelInformacionBusqueda extends JPanel {
	ControladorBusqueda controlador;
	
	JLabel etiquetaInformacion;
	JLabel etiquetaAcciones;
	JLabel etiquetaInstrumentation;
	JButton botonContinuar;
	
	public PanelInformacionBusqueda(String informacion,
			ControladorBusqueda controlador) {
		this.controlador=controlador;
		
		etiquetaInformacion=new JLabel(informacion);
		JPanel panelInformacion=new JPanel();
		panelInformacion.add(etiquetaInformacion);
		
		botonContinuar=new JButton(LocalSearchControlator.ACCION_CONTINUAR);
		botonContinuar.addActionListener(controlador);
		JPanel panelContinuar=new JPanel();
		panelContinuar.add(botonContinuar);
		
		this.setLayout(new GridLayout(2,1));
		this.add(panelInformacion);
		this.add(panelContinuar);
		this.setBorder(new TitledBorder("RESULTADO DE LA BUSQUEDA"));
	}
	
	public PanelInformacionBusqueda(String informacion,String acciones,String instrumentation,
			ControladorBusqueda controlador) {
		super();
		etiquetaInformacion=new JLabel(informacion);
		JPanel panelInformacion=new JPanel();
		panelInformacion.add(etiquetaInformacion);
		
		etiquetaAcciones=new JLabel("Acciones:\t"+acciones);
		JPanel panelAcciones=new JPanel();
		panelAcciones.add(etiquetaAcciones);
		JScrollPane panelAccionesScroll=new JScrollPane(panelAcciones);
		panelAccionesScroll.setPreferredSize(new Dimension(600,50));
		
		
		etiquetaInstrumentation=new JLabel ("Instrumentacion:\t"+instrumentation);
		JPanel panelInstrumentation=new JPanel();
		panelInstrumentation.add(etiquetaInstrumentation);
		JScrollPane panelInstrumentationScroll=new JScrollPane(panelInstrumentation);
		panelInstrumentationScroll.setPreferredSize(new Dimension(600,50));
		
		botonContinuar=new JButton(LocalSearchControlator.ACCION_CONTINUAR);
		botonContinuar.addActionListener(controlador);
		JPanel panelContinuar=new JPanel();
		panelContinuar.add(botonContinuar);
		
		this.setLayout(new GridLayout(4,1));
		this.add(panelInformacion);
		this.add(panelAccionesScroll);
		this.add(panelInstrumentationScroll);
		this.add(panelContinuar);
		this.setBorder(new TitledBorder("RESULTADO DE LA BUSQUEDA"));
		//this.setBorder(new EtchedBorder());
		//this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		//this.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
	}

	public PanelInformacionBusqueda(String informacion, String acciones, ControladorBusqueda controlador) {
		etiquetaInformacion=new JLabel(informacion);
		JPanel panelInformacion=new JPanel();
		panelInformacion.add(etiquetaInformacion);
		
		etiquetaAcciones=new JLabel("Error producido por:");
		JLabel ultimasAcciones=new JLabel(acciones);
		JPanel panelAcciones=new JPanel();
		panelAcciones.add(etiquetaAcciones);
		panelAcciones.add(ultimasAcciones);
		JScrollPane panelAccionesScroll=new JScrollPane(panelAcciones);
		panelAccionesScroll.setPreferredSize(new Dimension(600,50));
		
		botonContinuar=new JButton(LocalSearchControlator.ACCION_CONTINUAR);
		botonContinuar.addActionListener(controlador);
		JPanel panelContinuar=new JPanel();
		panelContinuar.add(botonContinuar);
		
		this.setLayout(new GridLayout(3,1));
		this.add(panelInformacion);
		this.add(panelAccionesScroll);
		this.add(panelContinuar);
		this.setBorder(new TitledBorder("RESULTADO DE LA BUSQUEDA"));
	}

}
