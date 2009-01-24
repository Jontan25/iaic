package com.iaic.search.informed;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;


public class HeuristicAndCostEvaluation implements EvaluationFunction {

	public Double obtainValue(Problem problem, Node node) {
		return new Double(node.getTotalCostD( ) +
						  problem.getFunHeuristic().heuristicValue(node.getState()));
	}

}
