/**
 * 
 */
package com.iaic.search;

import com.iaic.datastructures.ExpandNode;
import com.iaic.datastructures.OpenedStructure;
import problem.Problem;
import problem.Node;
import java.util.Vector;

/**
 * This class manage the search.
 * @author mario
 */
public abstract class SearchQueue extends ExpandNode {

	public SearchQueue(){}
	/**
	 * This function receive a problem and an opened structure and start a search
	 * of the objective state.Begin creating a node in the inicial state and
	 * add it to the opened structure. Then we take the node and see if it is
	 * the objective node, in the wrong case, we expand his sons and add it to 
	 * the opened structure.
	 * @param p Problem for wich we make the search.
	 * @param opened structure, it can be a stack, a queue...
	 * @return Vector with the operators applied since the inicial state
	 * up to the first objective state that we find.
	 */
	public Vector<String> search(Problem p,OpenedStructure opened) {
		Node inicialnode=new Node(p.getInicialState());
		opened.agregar(inicial);
		while (!opened.isEmpty()) {
			Node actual=opened.extract();
			if (p.esEstadoObjetivo(actual.getState())) {
				return actual.operatoPath();
			}
			//we take the next node from the opened structure
			//if it is objective, we finish
			AddandExpand(p,opened,actual);
			//if it is not objective we create the sons
			//and we add it to the structure.
		}
		return new Vector<String>();
	}
	
	public abstract void AddandExpand(Problem p, OpenedStructure opened, Node n);
}
