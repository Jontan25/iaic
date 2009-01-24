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
			misionerosEstado CruzaM=(misionerosEstado)actual.clone();
			CruzaM.cruzaM();
			sucesores.add(new Sucesor(CruzaM,CRUZAM));
		} 
		
		//Cruza 1 canibal
		if (actual.puedoCruzarCanibal()) {
			misionerosEstado CruzaC=(misionerosEstado)actual.clone();
			CruzaC.cruzaC();
			sucesores.add(new Sucesor(CruzaC,CRUZAC));
		} 
        
		//Cruzan 2 misioneros
		if (actual.puedoCruzar2Misioneros()) {
			misionerosEstado CruzaMM=(misionerosEstado)actual.clone();
			CruzaMM.cruzaMM();
			sucesores.add(new Sucesor(CruzaMM,CRUZAMM));
		}
        
		//Cruzan 2 canibales
		if (actual.puedoCruzar2Canibales()) {
			misionerosEstado CruzaCC=(misionerosEstado)actual.clone();
			CruzaCC.cruzaCC();
			sucesores.add(new Sucesor(CruzaCC,CRUZACC));
		}
		
		//Cruza 1 misionero y 1 canibal
		if (estadoActual.puedoVaciar3()) {
			misionerosEstado CruzaMC=(misionerosEstado)actual.clone();
			CruzaMC.cruzaMC();
			sucesores.add(new Sucesor(CruzaMC,CRUZAMC));
		}
		return sucesores;
	}

}
