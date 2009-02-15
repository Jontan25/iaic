package com.iaic.gameLauncher;
import java.util.List;
import java.util.Vector;


import javax.swing.JFrame;

import com.iaic.interfaces.ControladorBusquedaGlobal;
import com.iaic.interfaces.PanelBusqueda;
import com.iaic.problems.cube.CubeFactory;
import com.iaic.problems.cube.CubeHeuristicFunction;
import com.iaic.problems.cube.CubeSuccessorFunction;
import com.iaic.problems.laberinto.EstadoLaberinto;
import com.iaic.problems.laberinto.LaberintoHeuristicFunction;
import com.iaic.problems.laberinto.LaberintoSuccessorFunction;

/**
 * @author Enrique López Mañas
*/

public class GameLauncher {

	public static void main(String[] args) {
		JFrame practicaCubo=new JFrame();
		practicaCubo.setTitle("Universo planetario:");
		String descripcion="Descripción: Alcanza el planeta Arcadia sin que las malvadas naves Eldar acaben contigo";

		String operadores="Operadores y costes: "+CubeFactory.dameStringDeArray(CubeSuccessorFunction.ACCIONES);
		String objetivo="Los estados objetivo son las planetas Arcadia";
		String heuristica="Heuristica: "+CubeHeuristicFunction.DESCRIPCION;
		List datos=new Vector();
		datos.add(descripcion);
		//data.add(inicio);
		datos.add(operadores);
		datos.add(objetivo);
		datos.add(heuristica);
		
		PanelBusqueda panelInicial=new PanelBusqueda(datos);
		practicaCubo.getContentPane().add(panelInicial);
		ControladorBusquedaGlobal controlador=new ControladorBusquedaGlobal();
		panelInicial.associateController(controlador);
		practicaCubo.repaint();
		practicaCubo.pack();
		
		practicaCubo.show();
	}

}
