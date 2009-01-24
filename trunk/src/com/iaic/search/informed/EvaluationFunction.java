package com.iaic.search.informed;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;


public interface EvaluationFunction {

	public Double obtainValue(Problem p,Node n);
}
