package com.iaic.problem;
/**
 * It's not a node. It's a succesor that is created when we
 * deploy an extracted node from the opened structure.
 * @author jose, mario
 *
 */
public class Succesor {
	/**
	 * The state of the problem
	 */
	private Object state;
	/**
	 * The operator that we have to apply for getting this state
	 */
	private String operator;
	
	public Succesor(Object e,String o) {
		state=e;operator=o;
	}
	public Succesor() {
		this(null,"");
	}
	/**
	 * 
	 * @return The represented state.
	 */
	public Object getState() {
		return state;
	}
	/**
	 * 
	 * @return The operator that we have to take to get the state.
	 */
	public String getOperator() {
		return operator;
	}
}
