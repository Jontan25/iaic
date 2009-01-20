/**
 * 
 */
package com.iaic.noninformedsearch;
import com.iaic.search.Common;
import problem.Problema;
import java.util.Vector;

/**
 *This search it is very related with the limited depth search.
 *We make some search and for each one we increase in one unit the
 *depth of the search, until we find the solution.
 *@author mario
 */
public class IterativeDepth implements Common {ç
	
	private final int LIMIT=9999;
	
	/**
	 * This is a loop that makes different searches of
	 * limited depth until he find the solution or reach
	 * the higly limit.
	 */
	public Vector<String> search(Problem p) {
		Vector<String> sol=new Vector<String>();
		sol.clear();
		for (int i=1;i<=LIMIT;i++) {
			IterativeDepth id= new IterativeDepth(i);
			sol=id.search(p);
			if (!sol.isEmpty())
				return sol;
		}
		return new Vector<String>();
	}
}
