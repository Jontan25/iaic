package com.iaic.search.informed;


import java.util.Comparator;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

import com.iaic.search.PrioritySearch;
import com.iaic.search.SearchQueue;


public class FirstTheBest extends PrioritySearch {

	private EvaluationFunction evaluationFunction;
	
	public FirstTheBest() {
		this.evaluationFunction = null;
	}
	
	public FirstTheBest(SearchQueue searchQueue , EvaluationFunction evFunction ) {
		this.searchqueue = searchQueue; 
		this.evaluationFunction = evFunction ;
	}
	
	protected Comparator<Node> getComparator(final Problem p) {
		return new Comparator<Node>() {
			public int compare(Node uno, Node dos) {
				Double firstFunction = evaluationFunction.obtainValue(p, uno );
				Double secondFunction = evaluationFunction.obtainValue(p,dos);
				
				return firstFunction.compareTo(secondFunction);
			}
		};
	}

}
