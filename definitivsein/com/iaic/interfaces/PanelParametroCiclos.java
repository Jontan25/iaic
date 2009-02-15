package com.iaic.interfaces;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelParametroCiclos extends PanelParametrosBusqueda{
	JLabel etiquetaCiclo;
	JComboBox comboCiclo;
	
	public PanelParametroCiclos(String[] tipos){
		JPanel panelEtiqueta=new JPanel();
		etiquetaCiclo=new JLabel("Sistema de control de Ciclos: ");
		panelEtiqueta.add(etiquetaCiclo);
		
		JPanel panelCombo=new JPanel();
		comboCiclo=new JComboBox(tipos);
		panelCombo.add(comboCiclo);
		
		this.add(panelEtiqueta);
		this.add(panelCombo);
	}

	public Object dameParametro() {
		return comboCiclo.getSelectedItem();
	}

}
