package com.iaic.search.nonInformed;

import com.iaic.search.Search;
import com.iaic.problem.Problem;
import java.util.Vector;

public class IterativeDepth implements Search {

	private final int limit=9999;
	
	public Vector<String> search(Problem p) {
		Vector<String> sol=new Vector<String>();
		sol.clear();
		for (int i=1;i<=limit;i++) {
			LimitedDepth b=new LimitedDepth(i);
			sol=b.search(p);
			if (!sol.isEmpty())
				return sol;
		}
		return new Vector<String>();
	}
}
