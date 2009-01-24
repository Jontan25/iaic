/**
 * 
 */
package problems.missionary;

import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;

/**
 * @author mario
 */
public class misionerosSucesor implements FuncionSucesor {
	/*
	 * Los 5 operadores de este problema
	 */
	private final String CRUZAM="Cruza 1 misionero";
	private final String CRUZAC="Cruza 1 canibal";
	private final String CRUZAMM="Cruzan 2 misioneros";
	private final String CRUZACC="Cruzan 2 canibales";
	private final String CRUZAMC="Cruzan 1 misionero y 1 canibal";

	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionSucesor#getSucesores(java.lang.Object)
	 */
	@Override
	public Vector<Sucesor> getSucesores(Object estado) {
		Vector<Sucesor> sucesores=new Vector<Sucesor>();
		sucesores.clear();
		misionerosEstado actual=(misionerosEstado)estado;
		
		//Cruza 1 misionero
		if (actual.puedoCruzarMisionero()) {
			misionerosEstado CruzaM=(misionerosEstado)estadoActual.clone();
			CruzaM.volcarGarrafa3en4();
			sucesores.add(new Sucesor(CruzaM,CRUZAM));
		} 
		
		//Cruza 1 canibal
		if (estadoActual.puedoVolcar4en3()) {
			garrafasEstado _4en3=(garrafasEstado)estadoActual.clone();
			_4en3.volcarGarrafa4en3();
			sucesores.add(new Sucesor(_4en3,OP4EN3));
		} 
        
		//Cruzan 2 misioneros
		if (estadoActual.puedoLlenar3()) {
			garrafasEstado ll3=(garrafasEstado)estadoActual.clone();
			ll3.llenarGarrafa3();
			sucesores.add(new Sucesor(ll3,OPLLENA3));
		}
        
		//Cruzan 2 canibales
		if (estadoActual.puedoLlenar4()) {
			garrafasEstado ll4=(garrafasEstado)estadoActual.clone();
			ll4.llenarGarrafa4();
			sucesores.add(new Sucesor(ll4,OPLLENA4));
		}
		
		//Cruza 1 misionero y 1 canibal
		if (estadoActual.puedoVaciar3()) {
			garrafasEstado v3=(garrafasEstado)estadoActual.clone();
			v3.vaciarGarrafa3();
			sucesores.add(new Sucesor(v3,OPVACIA3));
		}//para vaciar la garrafa de 3l
		return sucesores;
	}

}
