package com.iaic.problems.peasant;

import com.iaic.problems.peasant.PeasantGoalTest;
import com.iaic.problems.peasant.PeasantSuccessorFunction;

import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.uninformed.DepthFirstSearch;

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
public class PeasantDemo {

	public static void main(String[] args) {
		System.out.println("\nGranjeroDemo DFS -->");
		 try {
			Problem problem =  new Problem(new PeasantState(),
				new PeasantSuccessorFunction(), 
				new PeasantGoalTest(new PeasantState(true,true,true,true)));
		
			Search search = new DepthFirstSearch(new GraphSearch());
			
			//SearchAgent agent = 
			new SearchAgent(problem, search);
			System.out.println("Busqueda terminada");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
