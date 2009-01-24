package com.iaic.search.informed;

import com.iaic.search.SearchQueue;


public class AStar extends FirstTheBest {

	public AStar(SearchQueue searchQueue) {
		super ( searchQueue , new EvaluacionHeuristicayCoste());
	}
}
