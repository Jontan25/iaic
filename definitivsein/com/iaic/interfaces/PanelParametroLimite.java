package com.iaic.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelParametroLimite extends PanelParametrosBusqueda{
	JLabel etiquetaLimite;
	JTextField textLimite;
	
	public PanelParametroLimite(){
		JPanel panelEtiqueta=new JPanel();
		etiquetaLimite=new JLabel("Limite: ");
		panelEtiqueta.add(etiquetaLimite);
		
		JPanel panelText=new JPanel();
		textLimite=new JTextField("10");
		textLimite.setPreferredSize(new Dimension(50,20));
		panelText.add(textLimite);
		
		this.add(panelEtiqueta);
		this.add(panelText);
	}

	public Object dameParametro() {
		Integer limite=new Integer(0);
		try{
			limite=new Integer(textLimite.getText());
			if (limite.intValue()<0){
				textLimite.setText("0");
				limite=new Integer(0);
			}
		}catch (NumberFormatException e){
			textLimite.setText("0");
		}
		return limite;
	}

}
