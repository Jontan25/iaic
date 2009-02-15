package com.iaic.problems.peasant;
import java.util.List;
import java.util.Vector;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeasantSuccessorFunction implements SuccessorFunction{

	public static String[] ACCIONES={"mover ("+PeasantStepCostFunction.COSTE_GRANJERO+")",
									"moverLobo ("+PeasantStepCostFunction.COSTE_LOBO+")",
									"moverOveja ("+PeasantStepCostFunction.COSTE_OVEJA+")",
									"moverCol  ("+PeasantStepCostFunction.COSTE_COL+")"};
	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	public List getSuccessors(Object estado) {
		List movimientos=new Vector();
		PeasantState peasantState= (PeasantState) estado;
		PeasantState nuevoEstado;
		boolean granjero=peasantState.dameGranjero();
		boolean lobo=peasantState.dameLobo();
		boolean oveja=peasantState.dameOveja();
		boolean col=peasantState.dameCol();
		try {
			nuevoEstado=new PeasantState(!granjero,lobo,oveja,col);
			movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
		} catch (Exception e) {
		}
		if (granjero==lobo){
			try {
				nuevoEstado=new PeasantState(!granjero,!lobo,oveja,col);
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
			} catch (Exception e) {
			}
		}
		if (granjero==oveja){
			try {
				nuevoEstado=new PeasantState(!granjero,lobo,!oveja,col);
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
			} catch (Exception e) {
			}
		}
		if (granjero==col){
			try {
				nuevoEstado=new PeasantState(!granjero,lobo,oveja,!col);
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
			} catch (Exception e) {
			}
		}
		
		return movimientos;
	}
	

}
