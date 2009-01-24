package com.iaic.search.informed;

import com.iaic.search.SearchQueue;

public class Greedy extends FirstTheBest {

	public Greedy ( SearchQueue searchQueue) {
		super(searchQueue,new EvaluacionHeuristica());
	}
}
