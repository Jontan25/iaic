package com.iaic.search.informed;


import java.util.Vector;

import com.iaic.problem.Problem;
import com.iaic.problem.Node;
import com.iaic.search.Search;
import com.iaic.datastructures.ExpandNode;

public class MaximumGradientClimbing extends ExpandNode implements Search {
	
	private boolean found;

	private Object lastState;
	
	
	public Vector<String> search(Problem problem) {
		this.lastState = null;
		Node actualNode = new Node(problem.getInitialState()),
		     sucesor = null;
		
		while (true) {
			sucesor=MaximumValueChild(expandNode(actualNode , problem),problem);
			if (sucesor==null || valorEscalada(problem,sucesor)<valorEscalada(problem,actualNode)) {
				if (problem.isAimState(actualNode.getState())) {
					this.found = true;
				}
				lastState = actualNode.getState();	
				return actualNode.wayOperators();
			}
			actualNode=sucesor;
		}
	}
	
	private Node MaximumValueChild(Vector<Node> l,Problem p) {
		double maximo=Double.NEGATIVE_INFINITY;
		Node nodoMaximo=null;
		int total=l.size();
		for (int i=0;i<total;i++) {
			Node a=l.get(i);
			double valorEval=valorEscalada(p,a);
			if (valorEval>maximo) {
				maximo=valorEval;
				nodoMaximo=a;
			}
		}
		return nodoMaximo;
	}

	private double valorEscalada(Problem p,Node n) {
		return -1*p.getFunHeuristic().heuristicValue(n.getState());
	}

	
	public boolean hasBeenFound() {
		return this.found;
	}
	
	public Object ultimoEstado() {
		return this.lastState;
	}
	
}
