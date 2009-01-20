/**
 * 
 */
package com.iaic.problems.Garrafas;

import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;

/**
 * @author alberto
 *
 */
public class garrafasSucesor implements FuncionSucesor {
	/*
	 * Los 6 operadores de este problema
	 */
	private final String OPLLENA3="Llenar la garrafa de 3l";
	private final String OPLLENA4="Llenar la garrafa de 4l";
	private final String OPVACIA3="Vaciar la garrafa de 3l";
	private final String OPVACIA4="Vaciar la garrafa de 4l";
	private final String OP3EN4="Volcar la garrafa de 3l en la de 4l";
	private final String OP4EN3="Volcar la garrafa de 4l en la de 3l";
	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionSucesor#getSucesores(java.lang.Object)
	 */
	@Override
	public Vector<Sucesor> getSucesores(Object estado) {
		Vector<Sucesor> sucesores=new Vector<Sucesor>();
		sucesores.clear();
		garrafasEstado estadoActual=(garrafasEstado)estado;
		
		if (estadoActual.puedoVolcar3en4()) {
			garrafasEstado _3en4=(garrafasEstado)estadoActual.clone();
			_3en4.volcarGarrafa3en4();
			sucesores.add(new Sucesor(_3en4,OP3EN4));
		} //para pasar de la de 3l a la de 4l
		
		if (estadoActual.puedoVolcar4en3()) {
			garrafasEstado _4en3=(garrafasEstado)estadoActual.clone();
			_4en3.volcarGarrafa4en3();
			sucesores.add(new Sucesor(_4en3,OP4EN3));
		} //para pasar de la de 4l a la de 3l
		if (estadoActual.puedoLlenar3()) {
			garrafasEstado ll3=(garrafasEstado)estadoActual.clone();
			ll3.llenarGarrafa3();
			sucesores.add(new Sucesor(ll3,OPLLENA3));
		}//para llenar la garrafa de 3l
		if (estadoActual.puedoLlenar4()) {
			garrafasEstado ll4=(garrafasEstado)estadoActual.clone();
			ll4.llenarGarrafa4();
			sucesores.add(new Sucesor(ll4,OPLLENA4));
		}//para llenar la garrafa de 4l
		if (estadoActual.puedoVaciar3()) {
			garrafasEstado v3=(garrafasEstado)estadoActual.clone();
			v3.vaciarGarrafa3();
			sucesores.add(new Sucesor(v3,OPVACIA3));
		}//para vaciar la garrafa de 3l
		if (estadoActual.puedoVaciar4()) {
			garrafasEstado v4=(garrafasEstado)estadoActual.clone();
			v4.vaciarGarrafa4();
			sucesores.add(new Sucesor(v4,OPVACIA4));
		}//para vaciar la garrafa de 4l
		return sucesores;
	}

}
