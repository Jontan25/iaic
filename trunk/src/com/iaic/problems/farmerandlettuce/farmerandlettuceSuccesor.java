/**
 * 
 */
package problems.farmerandlettuce;

import java.util.Vector;

import problema.Sucesor;
import problema.interfacesFunciones.FuncionSucesor;

/**
 * @author mario
 */
public class farmerandlettuceSuccesor implements FuncionSucesor {
	/*
	 * Los 4 operadores de este problema
	 */
	private final String CRUZASOLO="Cruza solo el granjero";
	private final String CRUZALECHUGA="Cruzan el granjero y la lechuga";
	private final String CRUZAOVEJA="Cruzan el granjero y la oveja";
	private final String CRUZALOBO="Cruzan el granjero y el lobo";


	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionSucesor#getSucesores(java.lang.Object)
	 */
	@Override
	public Vector<Sucesor> getSucesores(Object estado) {
		Vector<Sucesor> sucesores=new Vector<Sucesor>();
		sucesores.clear();
		farmerandlettuceState actual=(farmerandlettuceState)estado;
		
		//Cruza el granjero solo
		if (actual.puedoCruzarSolo()) {
			farmerandlettuceState CruzaSolo=(farmerandlettuceState)actual.clone();
			CruzaSolo.cruzaSolo();
			sucesores.add(new Sucesor(CruzaSolo,CRUZASOLO));
		} 
		
		//Cruza el granjero y la lechuga
		if (actual.puedoCruzarLechuga()) {
			farmerandlettuceState CruzaLechuga=(farmerandlettuceState)actual.clone();
			CruzaLechuga.cruzaLechuga();
			sucesores.add(new Sucesor(CruzaLechuga,CRUZALECHUGA));
		} 
        
		//Cruzan el granjero y la oveja
		if (actual.puedoCruzarOveja()) {
			farmerandlettuceState CruzaOveja=(farmerandlettuceState)actual.clone();
			CruzaOveja.cruzaOveja();
			sucesores.add(new Sucesor(CruzaOveja,CRUZAOVEJA));
		}
        
		//Cruzan el granjero y el lobo
		if (actual.puedoCruzarLobo()) {
			farmerandlettuceState CruzaLobo=(farmerandlettuceState)actual.clone();
			CruzaLobo.cruzaLobo();
			sucesores.add(new Sucesor(CruzaLobo,CRUZALOBO));
		}
		return sucesores;
	}

}
