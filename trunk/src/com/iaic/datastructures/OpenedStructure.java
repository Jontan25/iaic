
package com.iaic.datastructures;
import com.iaic.problem.Node;
import java.util.Vector;

/**
 * For all the searches we need to have an opened nodes structure,
 * in which we put the expanded nodes but not visited yet. Depending
 * on the type of search, this structure fills on on different ways 
 * and has some attributes or others.
 * 
 * We need functions to add and extract nodes of the opened queue, 
 * and to manage it. For this, it'll be defined on this interface, 
 * and then will implement different versions of the opened queue that
 * will define it in different ways: queue, priority queue, stack... 
 * 
 * @authors jose, mario
 *
 */
public interface OpenedStructure {
	/**
	 * This function adds a node to the opened structure.
	 * @param n node to add to the opened structure.
	 * @return True if there is no problem.
	 */
	public boolean add(Node n);
	/**
	 * This function extracts a node from the opened structure
	 * @return Extracted node.
	 */
	public Node extract();
	/**
	 * Evaluates if the opened structure is empty
	 * @return True if it's empty.
	 */
	public boolean isEmpty();
	/**
	 * 
	 * @return Number of nodes in the opened structure.
	 */
	public int NodesNumber();
	/**
	 * Adds a complete list of nodes to the structure. It's useful
	 * when we want to add a complete list of sons instead of add 
	 * one per one.
	 * @param v Vector con la lista de nodos que se quiere agregar.
	 * @return True si no ha habido errores.
	 */
	public boolean add(Vector<Node> v);
}
