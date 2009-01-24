package com.iaic.search.informed;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

public class HeuristicEvaluation implements EvaluationFunction {

	public Double obtainValue( Problem problem, Node node) {
		return new Double ( problem.getFunHeuristic().heuristicValue(node.getState()));
	}

}
