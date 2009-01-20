/**
 * 
 */
package com.iaic.search;

import java.util.Vector;
import java.util.Comparator;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

import estructurasDeDatos.ColaPrioridadAbiertos;

/**
 * Class for search that use a priority queue.
 * @author jose,mario
 *
 */
public abstract class PrioritySearch implements Search {
	/**
	 * This is the search queue structure that is going to be used.
	 * It can be a GraphSearch, if we want to have cycle control.
	 * All the search will use it, so we put it protected.
	 */
	protected SearchQueue searchqueue;
	
	
	/* (non-Javadoc)
	 * @see search.Search#search(problem.Problem)
	 */
	public Vector<String> search(Problem p) {
		return searchqueue.search(p,new OpenedPriorityQueue(getComparator(p)));
	}
	/**
	 * This method is used to build a priority queue.The queue needs a criteria
	 * to evaluate the priority between two nodes, and is show as Comparator class
	 * that implements the function "Compare", that compare two nodes and tell us
	 * what has more priority. We can build many other Compartor classes each one
	 * with is own Compare function.
	 * @param p, the problem for wich we want to make the search.
	 * @return the Comparator class that we need to create the priority queue
	 * (java.util.PriorityQueue)
	 */
	protected abstract Comparator<Node> getComparator(Problem p);

}
