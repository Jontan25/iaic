/**
 * 
 */
package com.iaic.datastructures;
import java.util.Vector;
import com.iaic.problem.Node;
import com.iaic.problem.Problem;
import com.iaic.problem.Succesor;
/**
 * This class just has the expandsNode function. This function
 * needs all the searches.
 * @author jose, mario
 *
 */
public class ExpandNode {
	
	public ExpandNode() {}
	
	/**
	 * This function expands a node of the search space, creating 
	 * all its son nodes and returning a list with them.
	 * 
	 * @param n The node that will be expanded.
	 * @param p The problem. It's needed because the succesor function is on it.
	 * @return A list with all the son nodes, result of expand n.
	 */
	public Vector<Node> expandNode(Node n, Problem p) {
		Vector<Node> sons=new Vector<Node>();
		sons.clear(); //we prepare the son nodes structure.
		
		Vector<Succesor> succesors=p.getFunSuccesor().getSuccesors(n.getState());
		/* With this, we have a vector of succesors states of the n node.
		 In each one, we have the applied operator to n.
		 Then, we have to create a node and add it to the list.
		 */
		int numSuccesors=succesors.size();
		//we take it first, because inside of the loop we quit them.
		
		for (int i=0;i<numSuccesors;i++) {
			Succesor s=succesors.remove(0);
			double gn=p.getFunCost().calculateCost(n.getState(), s.getState(), s.getOperator());
			Node newNode=new Node(s.getState(),n,s.getOperator(),gn,n.getTotalCost()+gn,n.getDepth()+1);
			sons.add(newNode);
		}
		return sons;
	}
}
