
package com.iaic.problem;
import java.util.Vector;

/**
 * The node is the structure that represents a node of the search tree
 * (not the state tree). There can be different nodes with the same state. 
 * It depends on the uses search and the cycle control methods...
 * This structure only contents an associated state, a reference to the
 * father's node and the needed costs and operators.
 * @author jose, mario
 *
 */
public class Node {
	/**
	 * The state of the state space that represents the node.
	 */
	private Object state;
	/**
	 * A reference to the father's node for the deplyed nodes.
	 * It can be useful for the back tracking.
	 */
	private Node father;
	/**
	 * The name of the operator that brings to this state. 
	 * It can be useful to know the order of the applied operators
	 * and to avoid cycles.
	 */
	private String operator;
	/**
	 * The cost of the way up this node g(n)
	 */
	private Double wayCost;
	/**
	 * Total cost from root to node.
	 */
	private Double totalCost;
	/**
	 * The depth of the node in the search tree.
	 */
	private Integer depth;
	
	
	public Node(Object e,Node p,String o,double c,double ct,int pr) {
		state=e;father=p;operator=o;
		wayCost=new Double(c);
		totalCost=new Double(ct);
		depth=new Integer(pr);
	}
	
	public Node(Object e,Node p,String o,double c,double ct) {
		this(e,p,o,c,ct,0);
	}
	
	public Node(Object e,Node p,String o,double c) {
		this(e,p,o,c,0,0);
	}
	
	public Node(Object e,Node p,String o) {
		this(e,p,o,0.0,0,0);
	}
	
	public Node(Object e,Node p) {
		this(e,p,"",0.0,0,0);
	}
	
	public Node(Object e) {
		this(e,null,"",0.0,0,0);
	}
	public Node() { 
		this(null,null,"",0.0,0,0);
	}
	
	/**
	 * Returns a Vector with the list of nodes from root to actual node,
	 * depth-sorted
	 * @return a Vector with the list of nodes from the root
	 */
	public Vector<Node> way() {
		Vector<Node> nodes=new Vector<Node>();
		nodes.clear();
		Node actual=this;
		while (actual.getDepth()!=0) {
			nodes.insertElementAt(actual,0);
			actual=actual.getFather();
		}
		nodes.insertElementAt(actual,0);
		return nodes;
		
	}
	
	public Vector<String> wayOperators() {
		Vector<String> opers=new Vector<String>();
		opers.clear();
		Node actual=this;
		while (actual.getDepth()!=0) {
			opers.insertElementAt(actual.getOperator(),0);
			actual=actual.getFather();
		}
		return opers;
	}
	
	/**
	 * 
	 * @return The depth of the node in the search tree
	 */
	public int getDepth() {
		return depth.intValue();
	}
	/**
	 * 
	 * @return The cost of the way to this node. g(n)
	 */
	public double getWayCost() {
		return wayCost.doubleValue();
	}
	/**
	 * 
	 * @return Cost from root to node (in double).
	 */
	public double getTotalCostD() {
		return totalCost.doubleValue();
	}
	/**
	 * 
	 * @return Cost from root to the node
	 */
	public Double getTotalCost() {
		return totalCost;
	}
	/**
	 * 
	 * @return eference to the father's node.
	 */
	public Node getFather() {
		return father;
	}
	/**
	 *
	 * @return The name of the operator that brings to the node. 
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 
	 * @return The state that stores this node.
	 */
	public Object getState() {
		return state;
	}
	
	public String toString() {
		return state.toString();
	}
	/*
	public int compare(Nodo a,Nodo b) {
		
	}*/
}
